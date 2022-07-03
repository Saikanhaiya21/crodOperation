package com.demo.beanvalidation;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class NameValidationImpl implements ConstraintValidator<NameValidation, Object> {

	private String fieldName;
	private List<String> fieldValues;

	@Override
	public void initialize(NameValidation annotation) {
		fieldName = annotation.fieldName();
		fieldValues = Arrays.asList(annotation.fieldValue());

	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext ctx) {

		if (value == null) {
			return true;
		}
		try {
			String fieldValue = BeanUtils.getProperty(value, fieldName);

			if (!fieldValues.contains(fieldValue)) {
				return false;

			}
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}
		return true;
	}
}
