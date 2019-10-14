package com.baizhi;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = CmfzApplication.class)
@RunWith(SpringRunner.class)
public class test {
    @Autowired
    //AdminMapper adminMapper;
            AdminService adminService;

    @Test
    public void find() {
        Admin byNameAndPassword = adminService.findByNameAndPassword("admin", "admin");
        System.out.println(byNameAndPassword);
    }
}
