package com.demo.showcase.commons.page;

import java.io.Serializable;
import java.util.List;
 
/**
 * 分页参数及查询结果封装
 */
public class DataPage<T> implements Serializable{
	private static final long serialVersionUID = 2193017612974315935L;
	
	private int pageNo = 1;
	private int pageSize = 20;
	private boolean needTotalCount = true;
	private boolean needDataList = true;
	
	private Long totalCount;
	private List<T> dataList;
	
	public DataPage(){
	}
	
	public DataPage(int pageNo, int pageSize){
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
	
	
	public int getTotalPages(){
		return (int)Math.ceil((double)this.totalCount / (double)this.pageSize);
	}
	
	/**
	 * 是否还有下一页 
	 */
	public boolean isHasNext(){
		return (this.pageNo + 1 <= this.getTotalCount());
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = (pageNo < 1 ? 1 : pageNo);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isNeedTotalCount() {
		return needTotalCount;
	}

	public void setNeedTotalCount(boolean needTotalCount) {
		this.needTotalCount = needTotalCount;
	}

	public boolean isNeedDataList() {
		return needDataList;
	}

	public void setNeedDataList(boolean needDataList) {
		this.needDataList = needDataList;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
}
