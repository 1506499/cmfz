package com.baizhi.service;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminService {
    Admin findByNameAndPassword(@Param("username") String username, @Param("password") String password);
}
