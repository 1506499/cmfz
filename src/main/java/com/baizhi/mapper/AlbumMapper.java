package com.baizhi.mapper;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumMapper {
    public List<Album> queryAll(@Param("begin") Integer begin, @Param("rows") Integer rows);

    public Integer count();

    public void add(Album album);

    public void updateUrl(Album album);

    public void updateStatus(Album album);

    public void updateCount(Album album);
}
