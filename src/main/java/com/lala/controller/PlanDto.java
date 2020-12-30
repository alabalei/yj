package com.lala.controller;

/**
 * @author yj
 * @date 2020/12/18 下午1:42
 */

public class PlanDto {



    private String xpath;

    private Integer type;

    private String keys;


    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public PlanDto(String xpath, Integer type, String keys) {
        this.xpath = xpath;
        this.type = type;
        this.keys = keys;
    }
}
