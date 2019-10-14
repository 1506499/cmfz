package com.baizhi.mapper;

import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterMapper {
    List<Chapter> queryAll(@Param("begin") Integer begin, @Param("rows") Integer rows, @Param("id") String id);

    Integer count(String id);

    void add(Chapter chapter);

    void updateUrl(Chapter chapter);

    void del(String[] id);
}
