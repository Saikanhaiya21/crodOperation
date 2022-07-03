package com.demo.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exception.ExceptionThrowsMethods;
import com.demo.requestbean.CheckValidNameBean;
import com.demo.responsebean.GenerateMessage;
import com.demo.utility.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping(value = Constants.STUDENT_ENDPOINT)
public class NameValidationController {

	private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();

	@PostMapping(value = Constants.VALID_NAME)
	public ResponseEntity<String> checkValidName(@Valid @RequestBody CheckValidNameBean checkValidNameBean) {

		return new ResponseEntity<>(gson.toJson(new GenerateMessage(null, "success")), HttpStatus.OK);
	}

	@PostMapping(value = Constants.NOTUSE_VALID)
	public ResponseEntity<String> notUseValidAnnotation(@Valid @RequestBody CheckValidNameBean checkValidNameBean) {
		ExceptionThrowsMethods aaa = new ExceptionThrowsMethods();
		aaa.checkValidation(checkValidNameBean);
		return new ResponseEntity<>(gson.toJson(new GenerateMessage(null, "success")), HttpStatus.OK);
	}
}
