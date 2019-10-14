package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.Map;

public interface ChapterService {
    Map<String, Object> queryAll(Integer page, Integer rows, String id);

    String add(Chapter chapter);

    void updateUrl(Chapter chapter);

    void del(String[] id);
}
