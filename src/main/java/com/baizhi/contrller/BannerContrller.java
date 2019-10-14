package com.baizhi.contrller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RestController
@RequestMapping("/banner")
public class BannerContrller {
    @Autowired
    BannerService bannerService;

    @RequestMapping("findAll")
    public List<Banner> findAll() {

        List<Banner> all = bannerService.findAll();
        return all;
    }

    @RequestMapping("/edit")
    public String edit(Banner banner, String oper, String[] id) {
        if (oper.equals("add")) {
            String s = UUID.randomUUID().toString();
            banner.setId(s);
            bannerService.save(banner);
            return s;
        }
        if ("edit".equals(oper)) {
            bannerService.updatestatus(banner);
        }
        if ("del".equals(oper)) {
            bannerService.del(id);
        }
        return null;
    }

    @RequestMapping("/upload")
    public void upload(MultipartFile imgpath, String bannerId, HttpSession session) {
        System.out.println(imgpath);
        String realPath = session.getServletContext().getRealPath("/img");

        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String originalFilename = imgpath.getOriginalFilename();
        String newFileName = new Date().getTime() + "_" + originalFilename;

        try {
            imgpath.transferTo(new File(realPath, newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bannerService.update(new Banner(bannerId, newFileName, null, null, null, null));
    }

    @RequestMapping("easypoi")
    public void easypoi(HttpServletResponse response) throws Exception {
        List<Banner> easypoi = bannerService.easypoi(response);
    }
}
