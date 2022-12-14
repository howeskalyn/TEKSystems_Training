/*
 * ShowSeek - Form
 * for change a user's password in the database.
 */

package com.capstone.ShowSeek.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdatePasswordForm {

	@NotEmpty(message = "Password is required.")
	@Length(max = 100, message = "Password must be less than 100 characters.")
	@Length(min = 8, message = "Password must be at least 8 characters.")
	private String password;

}
