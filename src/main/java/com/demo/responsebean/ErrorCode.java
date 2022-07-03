package com.demo.responsebean;

public class ErrorCode {

	private final String errorMessage;

	ErrorCode(int errorCode, String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public ErrorBean getErrorObject() {
		return new ErrorBean(this.errorMessage);
	}

	public ErrorBean getErrorObject(String appendMsg) {
		return new ErrorBean(this.errorMessage + " - " + appendMsg);
	}

}
