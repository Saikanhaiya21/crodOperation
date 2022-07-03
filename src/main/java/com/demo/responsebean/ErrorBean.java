package com.demo.responsebean;

public class ErrorBean {
	private String errorMessage;

	public ErrorBean() {
		super();
	}

	public ErrorBean(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
