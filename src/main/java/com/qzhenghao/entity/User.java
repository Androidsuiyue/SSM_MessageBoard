package com.qzhenghao.entity;

import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author suiyue
 * @since 2019-03-15
 */
@Data
public class User {

    private static final long serialVersionUID = 1L;

    /**
     * 自增标识
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 学工号
     */
    private String usernumber;
    /**
     * 密码
     */
    private String password;
    /**
     * 类型：
0-超管
1-教务
2-教师
3-学生
     */
    private Integer type;

    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话
     */
    private String tel;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}
