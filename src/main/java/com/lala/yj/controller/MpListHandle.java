package com.lala.yj.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author yj
 * @date 2020/12/18 下午2:08
 */
public class MpListHandle implements Runnable{


    @Override
    public void run() {
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setJavascriptEnabled(true);
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        WebDriver driver = new ChromeDriver(options);
        String href = driver.findElement(By.xpath("//*[@id=\"root\"]/div/span/div/main/div/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[10]/div/div/a")).getAttribute("href");
        String token = href.substring(href.indexOf("g_tk="),href.indexOf("&mgr_type")).substring(5);
        ChromeDriverProxy.tokenMap.put("token",token);
        try {
            ChromeDriverProxy.gitUpLoad(driver,token);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(res.toString());
//        for (PlanDto d:dto){
//            if (d.getType() == 1){
//                if ("//*[@id=\"target_next_step\"]".equals(d.getXpath())){
//                    driver.findElement(By.xpath(d.getXpath())).click();
//                    System.out.println("123123123123");
//                    driver.findElement(By.xpath(d.getXpath())).click();
//                    Set<String> windowHandles = driver.getWindowHandles();
//                    windowHandles.forEach(System.out::println);
//                    try {
//                        TimeUnit.SECONDS.sleep(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                } else if ("//*[@id=\"test_material_container\"]/div[1]/div".equals(d.getXpath())){
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    driver.findElement(By.xpath(d.getXpath())).click();
//                } else if ("//*[@id=\"choose_template\"]".equals(d.getXpath())){
//                    try {
//                        TimeUnit.SECONDS.sleep(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    driver.findElement(By.xpath(d.getXpath())).click();
//                } else if ("/html/body/div[7]/div/div/div[2]/div/div[1]/div[2]/div/div/div[2]/div[2]/button[1]".equals(d.getXpath())){
//                    try {
//                        TimeUnit.SECONDS.sleep(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    driver.findElement(By.xpath(d.getXpath())).click();
//                } else if ("//*[@id=\"test_creative_next_step\"]".equals(d.getXpath())){
//                    try {
//                        TimeUnit.SECONDS.sleep(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    driver.findElement(By.xpath(d.getXpath())).click();
//                } else if ("//*[@id=\"test_creative_next_step\"]".equals(d.getXpath())){
//                    driver.findElement(By.xpath(d.getXpath())).click();
//                    try {
//                        TimeUnit.SECONDS.sleep(3);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//                } else if ("//*[@id=\"test_confirmed_protocol\"]".equals(d.getXpath())){
//                    System.out.println(111);
//                    try {
//                        TimeUnit.SECONDS.sleep(3);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//                    driver.findElement(By.xpath(d.getXpath())).click();
////                    driver.findElement(By.xpath(d.getXpath())).click();
//                } else {
//                    driver.findElement(By.xpath(d.getXpath())).click();
//                }
//
//                /**
//                 *
//                 js1="document.documentElement.scrollTop=10000"
//                 driver.execute_script(js1)
//                 */
//            } else {
//                driver.findElement(By.xpath(d.getXpath())).sendKeys(d.getKeys());
//            }
//        }
    }
}
