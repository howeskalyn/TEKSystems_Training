/*
 * ShowSeek - Validation
 * for adding a user to the database.
 */

package com.capstone.ShowSeek.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.capstone.ShowSeek.db.dao.UserDAO;
import com.capstone.ShowSeek.db.entity.User;

public class EmailUniqueImpl implements ConstraintValidator<EmailUnique, String> {

	public static final Logger LOG = LoggerFactory.getLogger(EmailUniqueImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Override
	public void initialize(EmailUnique constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(value)) {
			return true;
		}

		User user = userDAO.findByEmail(value);

		return (user == null); // null? email does not exist, otherwise it already does & is not unique
	}

}