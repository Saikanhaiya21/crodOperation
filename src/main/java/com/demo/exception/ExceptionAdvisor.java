package com.demo.exception;

import com.demo.responsebean.ErrorBean;
import com.demo.responsebean.ErrorCode;
import com.demo.responsebean.ResponseBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionAdvisor {
	private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> methodArgumentNotValidException(@RequestBody MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<ObjectError> fieldErrors = result.getAllErrors();
		return new ResponseEntity<>(gson.toJson(this.processFieldErrors(fieldErrors)), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> methodNameNotValidException(@RequestBody ConstraintViolationException ex) {
		Set<ConstraintViolation<?>> violation = ex.getConstraintViolations();
		return new ResponseEntity<>(gson.toJson(this.violationError(violation)), HttpStatus.BAD_REQUEST);
	}

	private ResponseBean violationError(Set<ConstraintViolation<?>> violation) {
		List<ErrorBean> errorList = new ArrayList<>();
		for (ConstraintViolation<?> v1 : violation) {
			if (v1.getMessage() != null) {
				errorList.add(new ErrorBean(v1.getMessage()));
			}
		}

		return new ResponseBean("error", errorList);
	}

	private ResponseBean processFieldErrors(List<ObjectError> fieldErrors) {
		List<ErrorBean> errorList = new ArrayList<>();
		for (ObjectError fieldError : fieldErrors) {
			Object[] arguments = fieldError.getArguments();

			if (arguments != null) {
				boolean found = false;
				for (Object arg : arguments) {
					if (arg instanceof ErrorCode) {
						ErrorCode errCode = (ErrorCode) arg;
						errorList.add(new ErrorBean(errCode.getErrorMessage()));
						found = true;
						break;
					}
				}
				if (!found) {
					errorList.add(new ErrorBean(fieldError.getDefaultMessage()));
				}
			}
		}
		return new ResponseBean("error", errorList);
	}

}
