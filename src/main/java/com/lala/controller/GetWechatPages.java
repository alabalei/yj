package com.lala.controller;

import com.tencent.ads.ApiContextConfig;
import com.tencent.ads.TencentAds;
import com.tencent.ads.exception.TencentAdsResponseException;
import com.tencent.ads.exception.TencentAdsSDKException;
import com.tencent.ads.model.FilteringStruct;
import com.tencent.ads.model.WechatPagesGetResponseData;

import java.util.Arrays;
import java.util.List;

/**
 * @author yj
 * @date 2020/12/29 下午1:32
 */
public class GetWechatPages {


    /** YOUR ACCESS TOKEN */
    public String ACCESS_TOKEN = "f4c3bb62ee6b12340381ad460b2c9d7d";

    /** TencentAds */
    public TencentAds tencentAds;

    public Long accountId = 17749882L;

    public List<FilteringStruct> filtering = null;

    public Long page = 1L;

    public Long pageSize = 10L;
    //pageTemplateId
    public List<String> fields =
            Arrays.asList(
                    "page_id",
                    "page_name",
                    "created_time",
                    "last_modified_time",
                    "page_template_id",
                    "page_elements_spec_list",
                    "share_content_spec",
                    "preview_url",
                    "page_type");

    public void init() {
        this.tencentAds = TencentAds.getInstance();
        this.tencentAds.init(
                new ApiContextConfig().accessToken(ACCESS_TOKEN).isDebug(true)); // debug==true 会打印请求详细信息
        this.tencentAds.useProduction(); // 默认使用沙箱环境，如果要请求线上，这里需要设为线上环境
        this.buildParams();
    }

    public void buildParams() {}

    public WechatPagesGetResponseData getWechatPages() throws Exception {
        WechatPagesGetResponseData response =
                tencentAds.wechatPages().wechatPagesGet(accountId, filtering, page, pageSize, fields);
        return response;
    }

    public static void main(String[] args) {
        try {
            GetWechatPages getWechatPages = new GetWechatPages();
            getWechatPages.init();
            WechatPagesGetResponseData response = getWechatPages.getWechatPages();
            System.out.println(response);
        } catch (TencentAdsResponseException e) {
            e.printStackTrace();
        } catch (TencentAdsSDKException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
