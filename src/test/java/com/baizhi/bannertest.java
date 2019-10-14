package com.baizhi;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = CmfzApplication.class)
@RunWith(SpringRunner.class)
public class bannertest {
    @Autowired
    BannerService bannerService;

    // BannerMapper bannerMapper;
    @Test
    public void banner() {
        Banner banner = new Banner();
        banner.setId("1");
        banner.setStatus("y");
        bannerService.updatestatus(banner);
    }
}
