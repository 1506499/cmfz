package com.baizhi.contrller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/album")
public class AlbumContrller {
    @Autowired
    AlbumService albumService;

    @RequestMapping("queryAll")
    public Map<String, Object> queryAll(Integer page, Integer rows) {
        Map<String, Object> map = albumService.queryAll(page, rows);
        return map;
    }

    @RequestMapping("edit")
    public String edit(Album album, String oper) {
        if ("add".equals(oper)) {
            String s = albumService.add(album);
            return s;
        }
        if ("edit".equals(oper)) {
            albumService.updateStatus(album);
        }
        return null;
    }

    @RequestMapping("/upload")
    public void upload(MultipartFile cover, String albumId, HttpSession session) {
        String realPath = session.getServletContext().getRealPath("/img");
        File file = new File("realPath");
        if (!file.exists()) {
            file.mkdirs();
        }
        String originalFilename = cover.getOriginalFilename();
        String newFileName = new Date().getTime() + "_" + originalFilename;
        try {
            cover.transferTo(new File(realPath, newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Album album = new Album();
        album.setCover(newFileName);
        album.setId(albumId);
        albumService.updateUrl(album);
    }
}
