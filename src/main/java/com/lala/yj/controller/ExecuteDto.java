package com.lala.yj.controller;

import lombok.Data;

import java.util.List;

/**
 * @author yj
 * @date 2020/12/23 下午3:37
 */

@Data
public class ExecuteDto {


    private List<PlanDto> dto;

    private List<String> appIds;
}
