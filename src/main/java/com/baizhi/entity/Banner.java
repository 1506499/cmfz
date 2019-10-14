package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ExcelTarget(value = "e")
public class Banner {
    @Excel(name = "编号")//,needMerge = true)
    private String id;
    @Excel(name = "头像", type = 2)
    private String imgpath; //图片
    @Excel(name = "标题")
    private String title; //标题
    @Excel(name = "状态")
    private String status; //状态
    @Excel(name = "描述")
    private String desc; //描述
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", format = "yyyy-MM-dd")
    private Date create_date; //日期
}
