package com.lala.yj.controller;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author yj
 * @date 2020/12/18 下午2:08
 */
public class PlanHandle implements Runnable {


    public PlanHandle(List<PlanDto> dto) {
        this.dto = dto;
    }

    private List<PlanDto> dto;

//    public void changeWindow(WebDriver driver) {
//        // 存储原始窗口的 ID
//        String originalWindow = driver.getWindowHandle();
//
//// 检查一下，我们还没有打开其他的窗口
//        assert driver.getWindowHandles().size() == 1;
//
//// 点击在新窗口中打开的链接
//        driver.findElement(By.linkText("new window")).click();
//
//// 等待新窗口或标签页
//        wait.until(numberOfWindowsToBe(2));
//
//// 循环执行，直到找到一个新的窗口句柄
//        for (String windowHandle : driver.getWindowHandles()) {
//            if (!originalWindow.contentEquals(windowHandle)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }
//
//// 等待新标签完成加载内容
//        wait.until(titleIs("Selenium documentation"));
//    }

    public static String getLastHandle(WebDriver driver) {
        //获取当前打开窗口的所有句柄
        Set<String> Allhandles = driver.getWindowHandles();
        ArrayList<String> lst = new ArrayList<String>(Allhandles);
        return lst.get(lst.size()-1);
    }

    @SneakyThrows
    @Override
    public void run() {
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setJavascriptEnabled(true);
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        WebDriver driver = new ChromeDriver(options);
        for (PlanDto d : dto) {
            if ("//*[@id=\"wxadcontainer\"]/div[1]/div[2]/div[2]/div[4]/div[1]/div/div[2]/button".equals(d.getXpath())) {
                // 存储原始窗口的 ID
                driver.findElement(By.xpath(d.getXpath())).click();
                TimeUnit.SECONDS.sleep(1);
                String newHandle = getLastHandle(driver);
                // 循环执行，直到找到一个新的窗口句柄
                driver.switchTo().window(newHandle);
                continue;
            }
            if (d.getType() == 1) {
                if ("//*[@id=\"target_next_step\"]".equals(d.getXpath())) {
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
                } else if ("//*[@id=\"test_material_container\"]/div[1]/div".equals(d.getXpath())) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    driver.findElement(By.xpath(d.getXpath())).click();
                } else if ("//*[@id=\"choose_template\"]".equals(d.getXpath())) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    driver.findElement(By.xpath(d.getXpath())).click();
                } else if ("/html/body/div[7]/div/div/div[2]/div/div[1]/div[2]/div/div/div[2]/div[2]/button[1]".equals(d.getXpath())) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    driver.findElement(By.xpath(d.getXpath())).click();
                } else if ("//*[@id=\"test_creative_next_step\"]".equals(d.getXpath())) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    driver.findElement(By.xpath(d.getXpath())).click();
                } else if ("//*[@id=\"test_creative_next_step\"]".equals(d.getXpath())) {
                    driver.findElement(By.xpath(d.getXpath())).click();
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                } else if ("//*[@id=\"test_confirmed_protocol\"]".equals(d.getXpath())) {
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
                driver.findElement(By.xpath(d.getXpath())).sendKeys(d.getKeys());
            }
        }


    }
}
