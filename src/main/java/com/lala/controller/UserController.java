package com.lala.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/x")
public class UserController {


    @PostMapping("/test")
    public Boolean ossUpload(@RequestBody List<PlanDto> dto){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        WebDriver driver = new ChromeDriver(options);
//        driver.get("https://a.weixin.qq.com/client");
        for (PlanDto d:dto){
            if (d.getType() == 1){
                if ("//*[@id=\"target_next_step\"]".equals(d.getXpath())){
                    System.out.println("123123123123");
                    driver.findElement(By.xpath(d.getXpath())).click();
                    Set<String> windowHandles = driver.getWindowHandles();
                    windowHandles.forEach(System.out::println);
                    try {
                        driver.wait(3L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                driver.findElement(By.xpath(d.getXpath())).sendKeys(d.getKeys());
            }
        }
        return true;
    }






//    @CrossOrigin
//    @GetMapping("")
//    public Object get(){
//
//        return "Hellow,nidaye";
//    }
//
//    public static void main(String[] args) {
//        int[] res = maopao(new int[]{9,2,5,1,6,88,4,35,674,2,3});
//        System.out.println(Arrays.toString(res));
//    }
//
//
//    private static int[] maopao(int[] ints){
//
////        if (arr == null || arr.length < 2) {
////            4             return arr;
////            5         }
////        6         int n = arr.length;
////        7         for (int i = 0; i < n; i++) {
////            8             for (int j = 0; j < n -i - 1; j++) {
////                9                 if (arr[j + 1] < arr[j]) {
////                    10                     int t = arr[j];
////                    11                     arr[j] = arr[j+1];
////                    12                     arr[j+1] = t;
////                    13                 }
////                14             }
////            15         }
////        16         return arr;
//
//        if (ints == null || ints.length < 2){
//            return null;
//        }
//        int l = ints.length;
//        for (int i = 0;i<l;i++){
//            for (int j=0;j<l-i-1;j++){
//                if (ints[j+1]<ints[j]){
//                    int mid = ints[j];
//                    ints[j]=ints[j+1];
//                    ints[j+1] =mid;
//                };
//            }
//        }
//
//        return ints;
//
//    }
}
