package com.demo.responsebean;

import java.util.List;

public class ResponseBean {
	private String status;
	private List<ErrorBean> errors;

	public ResponseBean(String status, List<ErrorBean> errors) {
		super();
		this.status = status;
		this.errors = errors;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ErrorBean> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorBean> errors) {
		this.errors = errors;
	}

}
