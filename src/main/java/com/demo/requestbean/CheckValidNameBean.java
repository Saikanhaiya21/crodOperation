package com.demo.requestbean;

import com.demo.beanvalidation.NameValidation;

@NameValidation.List({
	@NameValidation(fieldName = "name", fieldValue = { "sai", "pravin" }, message = "Name not match") })

public class CheckValidNameBean {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
