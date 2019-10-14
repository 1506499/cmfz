package com.baizhi.mapper;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    Admin findByNameAndPassword(@Param("username") String username, @Param("password") String password);
}
