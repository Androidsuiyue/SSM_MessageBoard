package com.qzhenghao.controller;

import com.alibaba.fastjson.JSON;
import com.qzhenghao.dto.DTO;
import com.qzhenghao.entity.User;
import com.qzhenghao.service.JedisClient;
import com.qzhenghao.service.UserService;
import com.qzhenghao.utils.JavaWebToken;
import com.qzhenghao.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by ${符柱成} on 2017/4/2.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JedisClient jedisClient;

    @RequestMapping(value = "/insertUser", produces = "text/html;charset=UTF-8", method = {RequestMethod.GET, RequestMethod.GET})
    public String insertUser(String account, String country) {
        User user = new User();
        userService.insertUser(user);
        return JSON.toJSONString(user);
    }

    @RequestMapping(value = "/queryAll", produces = "text/html;charset=UTF-8", method = {RequestMethod.GET, RequestMethod.GET})
    public String queryAll() {
        List<User> userList = userService.queryAll();
        return JSON.toJSONString(userList);
    }

    @RequestMapping(value = "/deleteUser", produces = "text/html;charset=UTF-8", method = {RequestMethod.GET, RequestMethod.GET})
    public String deleteUser(Long id) {
        int t = userService.deleteUser(id);
        return JSON.toJSONString(t);
    }

    @RequestMapping(value = "/queryById", produces = "text/html;charset=UTF-8", method = {RequestMethod.GET, RequestMethod.GET})
    public String queryById(Long id) {
        User user = userService.queryById(id);
        return JSON.toJSONString(user);
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/main")
    public String main() {
        return "index";
    }

    @RequestMapping(value = "/queryTopN", produces = "text/html;charset=UTF-8", method = {RequestMethod.GET, RequestMethod.GET})
    public String queryTopN() {
        List<User> userList = null;
        try {
            Set<String> resultSet = jedisClient.zgetAll("Toptest", (long) 0, (long) 20);
            System.out.println("resultSet    " + resultSet.toString());
            Iterator<String> iter = resultSet.iterator();
            if (resultSet.size() > 0) {
                //字符串转为list
                System.out.println("有缓存啦啦啦！！！");
                userList = new ArrayList<>();
                while (iter.hasNext()) {
//                    JSONArray array = JSONArray.parseArray(iter.next());
                    User user = JsonUtils.jsonObjectToUser(iter.next());
                    System.out.println("user   " + user.toString());
                    userList.add(user);
                }
                return JSON.toJSONString(userList);
            } else {
                System.out.println("Toptest没查过");
                userList = userService.queryTopN();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            jedisClient.zaddList("Toptest", userList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSON.toJSONString(userList);
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public String login(String account) {
        User user = userService.login(account);
        DTO dto = new DTO();
        if (user == null) {
            dto.code = "-1";
            dto.msg = "Have not registered";
        } else {
            //把用户登录信息放进Session
            Map<String, Object> loginInfo = new HashMap<>();
            loginInfo.put("userId", user.getId());
            String sessionId = JavaWebToken.createJavaWebToken(loginInfo);
            dto.data = sessionId;
        }
        return JSON.toJSONString(user);
    }

}
