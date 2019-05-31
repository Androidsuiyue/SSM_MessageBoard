package com.qzhenghao.dao;

import com.qzhenghao.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ${符柱成} on 2017/3/31.
 */
public interface UserDao {
    User login(String account);
    //根据id查人
    User queryById(long id);
    //查询所有用户
    List<User> queryAll();
    //删除用户
    int deleteUser(long id);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertUser(User user);
    //修改用户积分
    void updateScore(@Param("id") long id, @Param("scoreCount") int scoreCount);
    //排行榜的查找topN
    List<User> queryTopN();
    //根据省份查用户
    List<User> findUserByProvince(@Param("province") String province);

    /**
     * 通过usernumber查询user
     * @param usernumber
     * @return
     */
    User queryByUsernumber(@Param("usernumber") String usernumber);



}
