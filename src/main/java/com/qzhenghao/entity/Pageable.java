package com.qzhenghao.entity;

import lombok.Data;

/**
 * 信用卡
 */
@Data
public class Pageable {

	//0开始
	private int pageNo;
	//每页数
	private int pageSize = 3;
	//
	public Pageable(int pageNo) {
		this.pageNo = pageNo;
	}

	public Pageable() {

	}
}
