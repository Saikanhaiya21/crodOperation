package com.demo.requestbean;

import javax.validation.constraints.NotEmpty;

public class StuRequestBean {

	@NotEmpty(message = "Name is required")
	private String name;

	@NotEmpty(message = "Address is required")
	private String Address;

	@NotEmpty(message = "mobile is required")
	private String mobileNo;

	public StuRequestBean() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

}
