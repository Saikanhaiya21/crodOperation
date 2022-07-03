package com.demo.requestbean;

import com.demo.beanvalidation.NotNullIfAnotherFieldHasValue;

@NotNullIfAnotherFieldHasValue.List({
		@NotNullIfAnotherFieldHasValue(fieldName = "id", dependFieldName = "name", message = "Name Can't be null"),
		@NotNullIfAnotherFieldHasValue(fieldName = "id", dependFieldName = "address", message = "Address Can't be null"),
		@NotNullIfAnotherFieldHasValue(fieldName = "id", dependFieldName = "mobileNo", message = "Mobile Number Can't be null") })
public class StuRequestBeanForUpdate {

	private Integer id;

	private String name;

	private String address;

	private String mobileNo;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

}
