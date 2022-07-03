package com.demo.responsebean;

public class StuResponseBean {

	private Integer id;
	
	private String name;

	private String mobileNo;

	private String address;

	public StuResponseBean(Integer id,String name, String mobileNo, String address) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.address = address;
	}

	public StuResponseBean() {
		super();

	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
