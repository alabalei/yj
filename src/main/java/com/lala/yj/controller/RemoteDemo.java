package com.lala.yj.controller;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author yj
 * @date 2020/12/25 上午11:10
 */
public class RemoteDemo {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        // RemoteWebDriver的基本使用
        //第一个参数：表示服务器的地址。第二个参数：表示预期的执行对象，其他的浏览器都可以以此类推
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.88.110:4444/wd/hub/"), DesiredCapabilities.firefox());
        driver.manage().window().maximize();
        driver.get("http://www.baidu.com");
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("alert('我现在在服务器')");
        Thread.sleep(2000);
        driver.quit();
    }
}
