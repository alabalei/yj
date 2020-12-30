package com.lala.yj.controller;

import lombok.Data;

import java.util.List;

/**
 * @author yj
 * @date 2020/12/23 下午3:22
 */
@Data
public class MpListVo {


    List<MpAccountDto> dtos;

    private Integer total;
}
