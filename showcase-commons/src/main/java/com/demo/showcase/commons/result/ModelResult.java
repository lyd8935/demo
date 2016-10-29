package com.demo.showcase.commons.result;

import java.io.Serializable;

/**
 * 用于服务器之间通讯传输 
 */
public class ModelResult implements Serializable{
	private static final long serialVersionUID = 4847496270320410821L;
	
	private String code;
	private String msg;
	private Object model;
	
	public ModelResult(String code, String msg, Object model){
		this.code = code;
		this.msg = msg;
		this.model = model;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getModel() {
		return model;
	}

	public void setModel(Object model) {
		this.model = model;
	}
}
