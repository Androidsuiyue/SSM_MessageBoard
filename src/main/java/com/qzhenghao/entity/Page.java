package com.qzhenghao.entity;

import java.util.List;

public class Page<T> {

	//页
	private int pageNo;
	
	// List
	private List<T> list;
	
	//每页数
	private int pageSize = 3;
	
	//书本总数
	private long totalItemNumber;

	// pageNo
	public Page(int pageNo) {
		super();
		this.pageNo = pageNo;
	}
	
	//得到当前页数
	public int getPageNo() {
		if(pageNo < 0)
			pageNo = 1;
		
		if(pageNo > getTotalPageNumber()){
			pageNo = getTotalPageNumber();
		}
		
		return pageNo;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setList(List<T> list) {
		this.list = list;
	}
	
	public List<T> getList() {
		return list;
	}
	
	//得到总页数
	public int getTotalPageNumber(){
		
		int totalPageNumber = (int)totalItemNumber / pageSize;
		
		if(totalItemNumber % pageSize != 0){
			totalPageNumber++;
		}
		
		return totalPageNumber;
	}
	
	public void setTotalItemNumber(long totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}
	
	public boolean isHasNext(){
		if(getPageNo() < getTotalPageNumber()){
			return true;
		}
		
		return false;
	}
	
	public boolean isHasPrev(){
		if(getPageNo() > 1){
			return true;
		}
		
		return false;
	}
	
	public int getPrevPage(){
		if(isHasPrev()){
			return getPageNo() - 1;
		}
		
		return getPageNo();
	}
	
	public int getNextPage(){
		if(isHasNext()){
			return getPageNo() + 1;
		}
		
		return getPageNo();
	}
}
