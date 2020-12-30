package com.lala.yj.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
@RequestMapping("/x")
public class UserController {


    @GetMapping("/mpl")
    public Boolean mpl(){
        MpListHandle mpListHandle = new MpListHandle();
        Executors.newSingleThreadExecutor().execute(mpListHandle);
        return true;
    }


    @PostMapping("/test")
    public Boolean ossUpload(@RequestBody List<PlanDto> dto){
        PlanHandle planHandle = new PlanHandle(dto);
        Executors.newSingleThreadExecutor().execute(planHandle);
//        driver.get("https://a.weixin.qq.com/client");
        return true;
    }

    @PostMapping("/ex")
    public Boolean ex(@RequestBody ExecuteDto dto){
        PlanHandleNew planHandle = new PlanHandleNew(dto.getAppIds(),dto.getDto());
        Executors.newSingleThreadExecutor().execute(planHandle);
//        driver.get("https://a.weixin.qq.com/client");
        return true;
    }


    @GetMapping("/list")
    public MpListVo ossUpload(Integer page,Integer size){
//        driver.get("https://a.weixin.qq.com/client");
        return ChromeDriverProxy.getList(page, size);
    }


    @GetMapping("/test1")
    public Boolean test1(){

        PlanDtoLo planHandle = new PlanDtoLo();
        Executors.newSingleThreadExecutor().execute(planHandle);
//        driver.get("https://a.weixin.qq.com/client");
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
