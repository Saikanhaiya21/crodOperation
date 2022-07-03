package com.demo.beanvalidation;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class NotNullIfAnotherFieldHasValueValidator
		implements ConstraintValidator<NotNullIfAnotherFieldHasValue, Object> {

	private String fieldName;
	private String dependFieldName;

	@Override
	public void initialize(NotNullIfAnotherFieldHasValue annotation) {
		fieldName = annotation.fieldName();
		dependFieldName = annotation.dependFieldName();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext ctx) {

		if (value == null) {
			return true;
		}

		try {
			String fieldValue = BeanUtils.getProperty(value, fieldName);
			String dependFieldValue = BeanUtils.getProperty(value, dependFieldName);

			if (fieldValue != null && (dependFieldValue == null || dependFieldValue == "")) {
				ctx.disableDefaultConstraintViolation();
				ctx.buildConstraintViolationWithTemplate(ctx.getDefaultConstraintMessageTemplate())
						.addPropertyNode(dependFieldName).addConstraintViolation();
				return false;
			}

		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}

		return true;
	}

}
