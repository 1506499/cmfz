package com.baizhi.service;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface AlbumService {
    public Map<String, Object> queryAll(@Param("begin") Integer begin, @Param("rows") Integer rows);

    public String add(Album album);

    public void updateUrl(Album album);

    public void updateStatus(Album album);
}
