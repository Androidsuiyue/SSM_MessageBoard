package com.qzhenghao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Message {

	private static final long serialVersionUID = 1L;

	private Integer id;
	//主题
	private String topic;
	//作者
	private int userId;
	//内容
	private String content;
	private String replyContent;

	//状态
	private int state;
	private String createTime;
	private String updateTime;
	private String userName;


}