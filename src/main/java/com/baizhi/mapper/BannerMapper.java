package com.baizhi.mapper;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerMapper {
    List<Banner> findAll();

    void update(Banner banner);

    void save(Banner banner);

    Banner findByid(String id);

    void updatestatus(Banner banner);

    void del(String[] id);

    List<Banner> easypoi();
}
