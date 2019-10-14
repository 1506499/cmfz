package com.baizhi.service;

import com.baizhi.entity.UserDate;
import com.baizhi.entity.UserEcharts;
import com.baizhi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<UserEcharts> queryAll() {
        List<UserEcharts> users = userMapper.queryAll();
        return users;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<UserDate> findAll() {
        List<UserDate> all = userMapper.findAll();
        return all;
    }
}
