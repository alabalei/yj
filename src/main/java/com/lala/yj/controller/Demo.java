package com.lala.yj.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static sun.font.FontUtilities.isWindows;

/**
 * @author yj
 * @date 2020/10/14 10:20 上午
 */
public class Demo {

    // 1608171135013

    public static final String first_xpath = "//*[@id=\"wxadcontainer\"]/div[1]/div[2]/div[2]/div[4]/div[1]/div/div[2]/button";

    private static void sendGet(String url) throws Exception {

//        String url = "http://www.google.com/search?q=mkyong";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //默认值我GET
        con.setRequestMethod("GET");

        //添加请求头
//        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //打印结果
        System.out.println(response.toString());

    }


    public static void main(String[] args) throws Exception {
//        System.out.println(System.currentTimeMillis());

//        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        // 1.创建webdriver驱动

        ProcessBuilder builder = new ProcessBuilder();
        String cmd = "sh -c \"/Applications/Google\\ Chrome.app/Contents/MacOS/Google\\ Chrome -remote-debugging-port=9222\"";
        if (isWindows) {
            builder.command("cmd.exe", "/c", "dir");
        } else {
            builder.command("sh", "-c", cmd);
        }
        builder.directory(new File(System.getProperty("user.home")));


//            String cmd = "sh -c \"/Applications/Google\\ Chrome.app/Contents/MacOS/Google\\ Chrome -remote-debugging-port=9222\"";
//        String cmdarray[] = {"sh -c \"/Applications/Google\\ Chrome.app/Contents/MacOS/Google\\ Chrome -remote-debugging-port=9222\""};
        Process pro = builder.start();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
//        options.addArguments("headless");
//        options.addArguments("no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        TimeUnit.SECONDS.sleep(1);
        driver.get("https://a.weixin.qq.com/client");
        System.out.println("-----------");
        int status = pro.waitFor();
        if (status != 0)
        {
            System.out.println("Failed to call shell's command ");
        }


//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        String token = (String) jsExecutor.executeScript("return sessionStorage.getItem('Token');");
//        System.out.println("token=" +token);
        //
        driver.findElement(By.xpath("/html/body/div[1]/div/span/div/main/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td/div/a")).click();



//        Set<String>  winHandels  =  driver .getWindowHandles();
//        List<String> it = new ArrayList<>(winHandels);
//        driver.switchTo().window(it.get(1));
//        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div/div[2]/button/span")).click();
//        winHandels = driver.getWindowHandles();
//        it = new ArrayList<>(winHandels);
//        System.out.println(winHandels.toString());
//        System.out.println(it.toString());
//        driver.switchTo().window(it.get(2));
//        //
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[6]/button/span")).click();
//        driver.quit();
        //



//
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[3]/div[3]/div[1]/div/button/span")).click();
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[3]/div[3]/div[3]/ol/li[1]")).click();
//
//
//
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[3]/div[3]/div[1]/button/span")).click();
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[3]/div[3]/div[3]/ol/li[1]")).click();
//
//
//
//        //
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[4]/div/div[2]/button[1]/span")).click();
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[4]/div/div[3]/div[1]/div/div")).click();
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[4]/div/div[3]/div[2]/div/div[1]")).click();
//
//
//
//
//
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[5]/div[2]/div[1]/div/input")).sendKeys("1000");
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[6]/button/span")).click();
//
//
//
//
//
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/div[2]/form/div[1]/div/div/label[1]/span[2]")).click();
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/div[2]/form/div[2]/div/div[1]/input")).sendKeys("2020-12-15");
//        //
//
//
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("2021-01-13");
//
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/div[2]/form/div[3]/div/div/label[1]")).click();
//
//
//
//
//
//
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[2]/div[1]/div/div[2]/div/div[1]/section[2]/form/div/div/div/button[2]/span")).click();
//
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[2]/div[1]/div/div[2]/div/div[1]/section[3]/div[2]/div[2]/div[2]/div[2]/div[1]/div/div/div/input")).sendKeys("北京");
//
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[2]/div[1]/div/div[2]/div/div[1]/section[1]/div[2]/form/div[3]/div/div/label[1]")).click();
//
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/form/div[2]/div/div[1]/button")).click();
//
//        ///html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/form/div[5]/div[3]/div/button/span
//
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/form/div[5]/div[3]/div/button/span")).click();
//
//
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/form/div[5]/div[3]/div/div")).sendKeys("");
//
//        ///html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[2]
//
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[2]/label/i")).click();
//        driver.findElement(By.xpath("")).click();
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/main/div/div[3]/div/button[2]")).click();



//        driver.manage().window().maximize();
//        Set<String> windows =  driver.getWindowHandles();
//
//        for (String temhandle : driver.getWindowHandles()) {
//            if (!temhandle.equals(driver.getWindowHandle())){
//                driver.close();
//                driver.switchTo().window(temhandle);
//            }
//        }


//        windows.forEach(System.out::println);


//        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div/div[2]/button/span")).click();
        // 3.获取输入框，输入selenium
//        driver.findElement(By.id("kw")).sendKeys("selenium");
        // 4.获取“百度一下”按钮，进行搜索
//        driver.findElement(By.id("su")).click();
        // 5.退出浏览器
//        driver.quit();






    }
}
