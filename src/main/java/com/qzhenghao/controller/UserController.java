package com.qzhenghao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ${符柱成} on 2017/4/2.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/doLogout", method = {RequestMethod.GET})
    public String doLogout(HttpServletRequest request,HttpSession httpSession){
        httpSession.setAttribute("currentUser",null);
        return "redirect:backend/mian";
    }







}
