package com.lala.yj.controller;

import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author yj
 * @date 2020/12/23 下午3:39
 */
public class PlanHandleNew implements Runnable{

    private List<String> appIds;
    private List<PlanDto> dto;

    private static final String firstUrl = "http://a.weixin.qq.com/cgi-bin/agency/redirect_mp?appid=%s&g_tk=%s&mgr_type=1";


    public PlanHandleNew(List<String> appIds, List<PlanDto> dto) {
        this.appIds = appIds;
        this.dto = dto;
    }

    public static String getLastHandle(WebDriver driver) {
        //获取当前打开窗口的所有句柄
        Set<String> allHandles = driver.getWindowHandles();
        ArrayList<String> lst = new ArrayList<String>(allHandles);
        return lst.get(lst.size()-1);
    }

    public static void closeWindow(WebDriver driver){
        Set<String> allHandles = driver.getWindowHandles();
        for (String s:allHandles){
            WebDriver driver1 = driver.switchTo().window(s);
            if (!"微信广告服务商平台".equals(driver1.getTitle())){
                driver1.close();
            }
        }
    }

    public void setAttribute(WebElement e, WebDriver d, String attributeName, String value) {
        JavascriptExecutor js = (JavascriptExecutor) d;
        // 执行JavaScriptdiamante修改页面元素属性。arguments[0]-[2]后面会用e,attributeName,value替换并执行
        js.executeScript("document.getElementsByClassName(\"adui-input-base\")[0].value="+value);
    }

    public void cAndv(){

    }

    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(stringSelection, null);
    }


    @SneakyThrows
    @Override
    public void run() {
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setJavascriptEnabled(true);
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        //   //*[@id="wxadcontainer"]/div[1]/div[2]/div[2]/div[4]/div[1]/div/div[2]/button
        for (String appId:appIds){
            WebDriver driver = new ChromeDriver(options);
            String realUrl = String.format(firstUrl,appId,ChromeDriverProxy.tokenMap.get("token"));
            String js = "window.open("+"\""+realUrl+"\");";
            JavascriptExecutor driver_js= ((JavascriptExecutor) driver);
            driver_js.executeScript(js);
            TimeUnit.SECONDS.sleep(2);
            String firstWindow =  getLastHandle(driver);
            driver.switchTo().window(firstWindow);

            for (PlanDto d:dto){
                if ("//*[@id=\"wxadcontainer\"]/div[1]/div[2]/div[2]/div[4]/div[1]/div/div[2]/button".equals(d.getXpath())) {
                    // 存储原始窗口的 ID
                    driver.findElement(By.xpath(d.getXpath())).click();
                    TimeUnit.SECONDS.sleep(1);
                    String newHandle = getLastHandle(driver);
                    // 循环执行，直到找到一个新的窗口句柄
                    driver.switchTo().window(newHandle);
                    continue;
                }
                if (d.getType() == 1){
                    if ("//*[@id=\"target_next_step\"]".equals(d.getXpath())){
                        driver.findElement(By.xpath(d.getXpath())).click();
                        System.out.println("123123123123");
                        driver.findElement(By.xpath(d.getXpath())).click();
                        Set<String> windowHandles = driver.getWindowHandles();
                        windowHandles.forEach(System.out::println);
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if ("//*[@id=\"test_material_container\"]/div[1]/div".equals(d.getXpath())){
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        driver.findElement(By.xpath(d.getXpath())).click();
                    } else if ("//*[@id=\"choose_template\"]".equals(d.getXpath())){
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        driver.findElement(By.xpath(d.getXpath())).click();
                    } else if ("/html/body/div[7]/div/div/div[2]/div/div[1]/div[2]/div/div/div[2]/div[2]/button[1]".equals(d.getXpath())){
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        driver.findElement(By.xpath(d.getXpath())).click();
                    } else if ("//*[@id=\"test_creative_next_step\"]".equals(d.getXpath())){
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        driver.findElement(By.xpath(d.getXpath())).click();
                    } else if ("//*[@id=\"test_creative_next_step\"]".equals(d.getXpath())){
                        driver.findElement(By.xpath(d.getXpath())).click();
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                    } else if ("//*[@id=\"test_confirmed_protocol\"]".equals(d.getXpath())){
                        System.out.println(111);
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                        driver.findElement(By.xpath(d.getXpath())).click();
//                    driver.findElement(By.xpath(d.getXpath())).click();
                    } else {
                        driver.findElement(By.xpath(d.getXpath())).click();
                    }

                    /**
                     *
                     js1="document.documentElement.scrollTop=10000"
                     driver.execute_script(js1)
                     */
                } else {
                    if ("//*[@id=\"wxadcontainer\"]/div[1]/div/div[2]/main/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/div[2]/form/div[2]/div/div[1]/input".equals(d.getXpath())
                       || "//*[@id=\"wxadcontainer\"]/div[1]/div/div[2]/main/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/div[2]/form/div[2]/div/div[2]/input".equals(d.getXpath())){
                        for (int i = 0;i<7;i++){
                            driver.findElement(By.xpath(d.getXpath())).sendKeys(Keys.BACK_SPACE);
                        }
                        driver.findElement(By.xpath(d.getXpath())).sendKeys(d.getKeys());
//                        List<WebElement> webElement = driver.findElements(By.className("adui-date-cell"));
//                        Integer year = Integer.parseInt(d.getKeys().substring(0,4));
//                        Integer month = Integer.parseInt(d.getKeys().substring(5,9));
//                        webElement.get(Integer.parseInt(d.getKeys())).click();
//                        setAttribute(driver.findElement(By.xpath(d.getXpath())),driver,"value",d.getKeys());
//                        JavascriptExecutor jse= ((JavascriptExecutor) driver);
//                        jse.executeScript()
//                        driver.findElement(By.xpath(d.getXpath())).sendKeys(Keys.DELETE);
//                        TimeUnit.SECONDS.sleep(1);
//                        driver.findElement(By.xpath(d.getXpath())).sendKeys(d.getKeys());
                    } else {
                        driver.findElement(By.xpath(d.getXpath())).sendKeys(d.getKeys());
                    }

                }
            }
            closeWindow(driver);
            TimeUnit.SECONDS.sleep(1);
        }



    }
}
