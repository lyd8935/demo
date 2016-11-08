package com.demo.showcase.commons.result;

import java.io.Serializable;

public abstract class BaseResult implements Serializable {
	private static final long serialVersionUID = 5263643324233993553L;
	
	/** 是否成功 */
	private boolean isSuccess = true;
	/** 输出编码     格式：系统.模块.编码 */
	private String code;
	/** 输出信息 */
	private String msg;
	
	public <T extends BaseResult> T withSuccess(String code, String msg){
		this.isSuccess = true;
		this.code = code;
		this.msg = msg;
		return (T)this;
	}

	public <T extends BaseResult> T withError(String code, String msg){
		this.isSuccess = false;
		this.code = code;
		this.msg = msg;
		return (T)this;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
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
}
