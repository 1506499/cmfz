package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Chapter {
    private String id;
    private String title;
    private String size;
    private String longTime;
    private Date createDate;
    private String url;
    private String albumId;
}
