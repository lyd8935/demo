package com.demo.showcase.commons.result;

public class ModelResult<T> extends BaseResult{
	private static final long serialVersionUID = -81997620726026010L;
	
	private T model;
	
	public ModelResult(){
		super();
	}
	
	public ModelResult(T model){
		this.model = model;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}
}
