package com.baizhi;

import com.baizhi.entity.UserEcharts;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = CmfzApplication.class)
@RunWith(SpringRunner.class)
public class albumtest {
    @Autowired
    UserService userService;

    @Test
    public void aa() {
        List<UserEcharts> userEcharts = userService.queryAll();
        for (UserEcharts userEchart : userEcharts) {
            System.out.println(userEchart);
        }
    }

}