package com.demo.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

public class ExceptionThrowsMethods {

	@Autowired
	private Validator validator;

	public  void checkValidation(Object checkValidNameBean) {
		Set<ConstraintViolation<Object>> violations = this.validator.validate(checkValidNameBean);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
	}
}
