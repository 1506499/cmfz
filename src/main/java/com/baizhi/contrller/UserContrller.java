package com.baizhi.contrller;

import com.baizhi.entity.UserDate;
import com.baizhi.entity.UserEcharts;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserContrller {
    @Autowired
    UserService userService;

    @RequestMapping("/queryAll")
    public List<UserEcharts> queryAll() {
        List<UserEcharts> userEcharts = userService.queryAll();
        return userEcharts;
    }

    @RequestMapping("/findAll")
    public List<UserDate> findAll() {
        List<UserDate> all = userService.findAll();
        return all;
    }
}
