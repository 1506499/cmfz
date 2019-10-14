package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Album {
    private String id;
    private String title;
    private Integer score;
    private String author;
    private String beam;
    private Integer count;
    private String brief;
    private String status;
    private Date publishDate;
    private String cover;
}
