package com.baizhi.service;

import com.baizhi.entity.Banner;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface BannerService {
    List<Banner> findAll();

    void save(Banner banner);

    Banner findByid(String id);

    void update(Banner banner);

    void updatestatus(Banner banner);

    void del(String[] id);

    List<Banner> easypoi(HttpServletResponse response) throws Exception;
}
