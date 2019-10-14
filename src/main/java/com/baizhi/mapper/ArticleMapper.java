package com.baizhi.mapper;

import com.baizhi.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    List<Article> queryAll(@Param("start") Integer start, @Param("rows") Integer rows);

    Integer getCount();

    void update(Article article);

    void add(Article article);
}
