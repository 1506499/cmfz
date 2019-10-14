package com.baizhi.service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Banner;
import com.baizhi.mapper.BannerMapper;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Banner> findAll() {
        List<Banner> all = bannerMapper.findAll();
        return all;
    }

    @Override
    public void save(Banner banner) {
        bannerMapper.save(banner);
    }

    @Override
    public Banner findByid(String id) {
        Banner byid = bannerMapper.findByid(id);
        return byid;
    }

    @Override
    public void update(Banner banner) {
        bannerMapper.update(banner);
    }

    @Override
    public void updatestatus(Banner banner) {
        bannerMapper.updatestatus(banner);
    }

    @Override
    public void del(String[] id) {
        bannerMapper.del(id);
    }


    @Override
    public List<Banner> easypoi(HttpServletResponse response) throws Exception {
        List<Banner> easypoi = bannerMapper.easypoi();
        for (Banner banner : easypoi) {
            banner.setImgpath("D:\\ideaSource\\cmfz\\src\\main\\webapp\\img\\" + banner.getImgpath());
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("轮播图信息", "图片"),
                Banner.class, easypoi);
        String encode = URLEncoder.encode("轮播图信息.xls", "UTF-8");
        response.setHeader("content-disposition", "attachment;filename=" + encode);

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);

        return null;
    }
}
