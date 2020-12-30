package com.lala.yj.controller;

import com.alibaba.fastjson.JSONObject;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @author yj
 * @date 2020/12/23 上午11:35
 */
public class ChromeDriverProxy extends ChromeDriver {
    private static final int COMMAND_TIMEOUT = 5000;
    // 必须固定端口，因为ChromeDriver没有实时获取端口的接口；
    private static final int CHROME_DRIVER_PORT = 9999;
    public static ChromeDriverService driverService = new ChromeDriverService.Builder().usingPort(CHROME_DRIVER_PORT).build();

    private static final String mpListUrl = "https://a.weixin.qq.com/cgi-bin/agency/get_delivery_metrics?page=%s&page_size=100&ascending=1&only_collect=0&g_tk=%s&_=%s";

    public static final List<MpAccountDto> mplist = new ArrayList<>(500);

    public static  Integer totalMp = 0;

    public static final Map<String,String> tokenMap = new HashMap<>();

    public ChromeDriverProxy(ChromeOptions options) {
        super(driverService, options);
    }

    public static MpListVo  getList(Integer page, Integer size) {
        MpListVo mpListVo = new MpListVo();
        mpListVo.setTotal(totalMp);
        int total = mplist.size();
        if (page * size > total) {
            mpListVo.setDtos(mplist.subList((page-1)*size,total));

        } else {
            mpListVo.setDtos(mplist.subList((page-1)*size,(page-1)*size+size));
        }
        return mpListVo;
    }

    public static void gitUpLoad(WebDriver driver, String token) throws Exception {
        HttpHeaders headers = getHeader(driver);//获取header
        RestTemplate template = new RestTemplate();
//        MultiValueMap<String,String> param = new LinkedMultiValueMap<String, String>();//参数放入一个map中，restTemplate不能用hashMap
        HttpEntity request = new HttpEntity(headers);


//        Map<String,Object> param = new HashMap<>();//参数放入一个map中，restTemplate不能用hashMap
//        //将请求参数放入map中
//        param.put("page",1);
//        param.put("page_size",10);
//        param.put("ascending",1);
//        param.put("only_collect",1);
//        param.put("g_tk",token);
//        param.put("_",System.currentTimeMillis());
        String realUrl = String.format(mpListUrl, String.valueOf(1), token, String.valueOf(System.currentTimeMillis()));
        ResponseEntity<JSONObject> exchange = template.exchange(realUrl, HttpMethod.GET, request, JSONObject.class);
        JSONObject jsonObject = exchange.getBody();
        assert jsonObject != null;
        List<MpAccountDto> mpAccountDtos = jsonObject.getJSONArray("list").toJavaList(MpAccountDto.class);
        mplist.addAll(mpAccountDtos);
        int total = jsonObject.getJSONObject("page_info").getIntValue("total");
        totalMp = total;
        if (total > 100) {
            int p = total / 100 + (total % 100 > 0 ? 1 : 0);
            for (int i = 2; i <= p; i++) {
                String realUrl1 = String.format(mpListUrl, String.valueOf(i), token, String.valueOf(System.currentTimeMillis()));
                ResponseEntity<JSONObject> exchange1 = template.exchange(realUrl1, HttpMethod.GET, request, JSONObject.class);
                JSONObject jsonObject1 = exchange1.getBody();
                assert jsonObject1 != null;
                List<MpAccountDto> mpAccountDtos1 = jsonObject1.getJSONArray("list").toJavaList(MpAccountDto.class);
                mplist.addAll(mpAccountDtos1);
            }
        }
        System.out.println(mplist.toString());
        System.out.println(mpAccountDtos.toString());
        System.out.println(total);
        System.out.println();
        System.out.println(jsonObject.get("list"));
    }


    public static HttpHeaders getHeader(WebDriver driver) {
        HttpHeaders headers = new HttpHeaders();
        Set<Cookie> cookies = driver.manage().getCookies();//获取浏览器cookies
        List<String> cookieList = new ArrayList<String>();
        for (Cookie cookie : cookies) { //将浏览器cookies放入list中
            //System.out.println("当前cookies为:" +  cookie.getDomain() + " " + cookie.getName() + ":" + cookie.getValue());
            cookieList.add(cookie.getName() + "=" + cookie.getValue());
        }
        //System.out.println("cookie为：" + cookieList.toString());
        headers.put(HttpHeaders.COOKIE, cookieList); //将cookie放入header
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); //post表单 ，如果是个json则设置为MediaType.APPLICATION_JSON
        return headers;

    }

    // 根据请求ID获取返回内容
//    public ResponseBodyVo getResponseBody(String requestId) {
//        ResponseBodyVo result = null;
//
//        try {
//            // CHROME_DRIVER_PORT chromeDriver提供的端口
//            String url = String.format("http://localhost:%s/session/%s/goog/cdp/execute",
//                    CHROME_DRIVER_PORT, getSessionId());
//            RestTemplate restTemplate = new RestTemplate();
//            HttpHeaders httpHeaders = new HttpHeaders();
//            httpHeaders.add();
//            restTemplate.getForEntity(url,JSONObject.class);
//            HttpPost httpPost = new HttpPost(url);
//            JSONObject object = new JSONObject();
//            JSONObject params = new JSONObject();
//            params.put("requestId", requestId);
//            object.put("cmd", "Network.getResponseBody");
//            object.put("params", params);
//
//            httpPost.setEntity(new StringEntity(object.toString()));
//
//            RequestConfig requestConfig = RequestConfig
//                    .custom()
//                    .setSocketTimeout(COMMAND_TIMEOUT)
//                    .setConnectTimeout(COMMAND_TIMEOUT).build();
//
//            CloseableHttpClient httpClient = HttpClientBuilder.create()
//                    .setDefaultRequestConfig(requestConfig).build();
//
//            HttpResponse response = httpClient.execute(httpPost);
//
//            JSONObject data = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
//            return JSONObject.toJavaObject(data, ResponseBodyVo.class);
//        } catch (IOException e) {
//            logger.error("getResponseBody failed!", e);
//        }
//
//        return result;
//    }

}
