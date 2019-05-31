package com.qzhenghao.service;

import com.qzhenghao.entity.User;

import java.util.List;

/**
 * @author suiyue
 */
public interface UserService {
    /**
     * 登录接口
     * @param usernumber
     * @return
     */
    User login(String usernumber);
    //根据id查人
    User queryById(long id);

    String register(String usernumber, String email, String name, String password, String tel);
    //查询所有用户
    List<User> queryAll();
    //删除用户
    int deleteUser(long id);
    //增加用户
    int insertUser(User user);
    //排行榜的查找topN
    List<User> queryTopN();
    //根据省份查用户
    List<User> findUserByProvince(String province);


}
