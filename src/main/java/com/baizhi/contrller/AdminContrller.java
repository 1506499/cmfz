package com.baizhi.contrller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
public class AdminContrller {
    @Autowired
    AdminService adminService;

    @ResponseBody
    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request, String code, Admin admin) {
        Admin byNameAndPassword = adminService.findByNameAndPassword(username, password);

        String verCode = (String) request.getSession().getAttribute("verCode");
        request.getSession().setAttribute("admin", admin);
        if (byNameAndPassword != null) {
            if (code.equals(verCode)) {
                return "success";
            }
            return "验证码错误";
        } else {
            return "账号或者密码错误";
        }
    }

    @RequestMapping("/exit")
    public String exit(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login/login.jsp";
    }

    @ResponseBody
    @RequestMapping("/image")
    public void image(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        // 存入会话session
        HttpSession session = request.getSession(true);
        // 删除以前的
        session.removeAttribute("verCode");
        session.removeAttribute("codeTime");
        session.setAttribute("verCode", verifyCode.toLowerCase());
        session.setAttribute("codeTime", LocalDateTime.now());
        // 生成图片
        int w = 100, h = 30;
        OutputStream out = response.getOutputStream();
        VerifyCodeUtils.outputImage(w, h, out, verifyCode);
    }
}
