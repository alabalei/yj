package com.lala.controller;

/**
 * @author yj
 * @date 2020/12/23 上午10:31
 */
public class StringText {


    public static void main(String[] args) {
        String l = "【福利】冬至到！#粉丝昵称#！送上书币暖暖身!" +
                "<br/><br/>┌——❄冬至福利❄——┐<br/>" +
                "<a href= \"https://c90003.818tu.com/pages/promotion-v0.html?pid=1395760&amp;promotion_id=1085625\\\">充15元送15，共得1500书币</a >" +
                " <br/>└——❄点击领取❄——┘<br/><br/>\uD83D\uDD25 <a href=\\\"https://c90003.818tu.com/referrals/index/18050483\\\">《圣医下山》</a >" +
                " <br/><br/>" +
                "⚡ <a href=\\\"https://c90003.818tu.com/referrals/index/18050496\\\">《神眼医少》</a >" +
                " <br/><br/>\uD83C\uDF38 <a href=\\\"https://c90003.818tu.com/referrals/index/18050543\\\">《龙婿临门》</a > 已更新！<br/><br/>↓↓更多精彩，戳菜单栏。";


        String l1 = "【福利】冬至到！#粉丝昵称#！送上书币暖暖身!" +
                "<br/><br/>┌——❄冬至福利❄——┐<br/>" +
                "<a href= \"https://c90003.818tu.com/pages/promotion-v0.html?pid=1395760&amp;promotion_id=1085625\\\">充15元送15，共得1500书币</a >" +
                " <br/>└——❄点击领取❄——┘<br/><br/>\uD83D\uDD25 <a href=\\\"https://c90003.818tu.com/referrals/index/18050483\\\">《圣医下山》</a >" +
                " <br/><br/>" +
                "⚡ <a href=\\\"https://c90003.818tu.com/referrals/index/18050496\\\">《神眼医少》</a >" ;
        System.out.println(l.getBytes().length);
        System.out.println(l1.getBytes().length);
    }
}
