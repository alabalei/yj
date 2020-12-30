package com.lala.yj.controller;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author yj
 * @date 2020/12/18 下午6:05
 */

public class PlanDtoLo implements Runnable{

    @Override
    public void run() {
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setJavascriptEnabled(true);
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        WebDriver driver = new ChromeDriver(options);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
