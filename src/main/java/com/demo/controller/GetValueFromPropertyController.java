package com.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.utility.Constants;

@RestController
@RequestMapping(value = Constants.STUDENT_ENDPOINT)
public class GetValueFromPropertyController {

	@Value("${Sai}")
	private String value;

	@GetMapping(value = Constants.GETVALUE_VALUE)
	public void getPropertyValue() {

		System.out.println(value);

	}

}
