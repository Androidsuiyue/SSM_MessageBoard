package com.qzhenghao.dao;

import com.qzhenghao.entity.Message;
import com.qzhenghao.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ${符柱成} on 2017/3/31.
 */
public interface MessageDao {


    /**
     * 添加留言
     * @param message
     * @return
     */
    int insertUser(Message message);

    /**
     * 更新内容
     * @param id
     * @param scoreCount
     */
    void updatecontent(@Param("id") long id, @Param("content") String scoreCount);

    /**
     * 通过id查询
     *
     * @return
     */
    Message queryByid(@Param("id") int id);

    /**
     * 计算所有id数
     */
    long queryAllCountId();

    List<Message> queryAllPageOrdeByState(@Param("pageNo") int pageNo,@Param("pageSize") int pageSize);


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
