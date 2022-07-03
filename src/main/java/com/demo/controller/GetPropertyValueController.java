package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.utility.Constants;

@RestController
@RequestMapping(value = Constants.STUDENT_ENDPOINT)
public class GetPropertyValueController {

	@Autowired
	private Environment env;

	@GetMapping(value = Constants.GET_VALUE)
	public void getPropertyValue() {

		System.out.println(this.env.getProperty("value"));

	}

}
