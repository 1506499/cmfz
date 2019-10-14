package com.baizhi.mapper;

import com.baizhi.entity.UserDate;
import com.baizhi.entity.UserEcharts;

import java.util.List;

public interface UserMapper {
    List<UserEcharts> queryAll();

    List<UserDate> findAll();
}
