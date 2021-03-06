package com.qzhenghao.controller;

import com.qzhenghao.entity.User;
import com.qzhenghao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 符柱成 on 2017/4/28.
 */
@Controller
@RequestMapping("/backend")
public class MainController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/mian", method = {RequestMethod.GET})
    public String mianPage(HttpServletRequest request, String username, String password) {
        return "index";
    }

    @RequestMapping(value = "/loginPage", method = {RequestMethod.GET})
    public String loginPage(HttpServletRequest request, String username, String password) {
        return "login";
    }
    @RequestMapping(value = "/registerPage", method = {RequestMethod.GET})
    public String registerPage(HttpServletRequest request, String username, String password) {
        return "register";
    }

    @RequestMapping(value = "/doLogin", method = {RequestMethod.POST})
    public String login(HttpServletRequest request, HttpServletResponse response, RedirectAttributes model, HttpSession httpSession, String username, String password) throws IOException, ServletException {
        //判断用户名密码是否正确
        User user = userService.login(username);
        if (null != user) {
            String password1 = user.getPassword();
            if (password.equals(password1)) {
                //将当前用户放入session中
                httpSession.setAttribute("currentUser", user);
                //跳转到主页
                return "redirect:mian";
            }
        }
        //提示错误
        model.addFlashAttribute("loginError", "密码错误");
        return "redirect:loginPage";
    }


    @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
    public String doRegister(HttpServletRequest request, HttpServletResponse response,String usernumber, String email, String name, RedirectAttributes model, String password, String tel) {
        String register = userService.register(usernumber, email, name, password, tel);
        model.addFlashAttribute("registerError", register);
        if ("success".equals(register)) {
            //成功到登录页
            return "redirect:loginPage";
        }
        return "redirect:registerPage";
    }


    @RequestMapping(value = "/loginSuccess", method = {RequestMethod.GET})
    public String accusationPage(HttpServletRequest request) {
        return "index";
    }


}
