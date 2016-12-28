package com.showcase.commons.result;

import com.showcase.commons.page.DataPage;

public class PageResult<T> extends BaseResult{
	private static final long serialVersionUID = -8327364438264898151L;
	
	private DataPage<T> dataPage;
	
	public PageResult(){
		super();
	}
	
	public PageResult(DataPage<T> dataPage){
		this.dataPage = dataPage;
	}
	
	public DataPage<T> getDataPage() {
		return dataPage;
	}

	public void setDataPage(DataPage<T> dataPage) {
		this.dataPage = dataPage;
	}
}
