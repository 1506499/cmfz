package com.baizhi.service;

import com.baizhi.entity.UserDate;
import com.baizhi.entity.UserEcharts;

import java.util.List;

public interface UserService {
    List<UserEcharts> queryAll();

    List<UserDate> findAll();
}
