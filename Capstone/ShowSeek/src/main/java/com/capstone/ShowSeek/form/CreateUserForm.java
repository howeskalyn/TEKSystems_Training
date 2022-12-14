/*
 * ShowSeek - Form
 * for adding a user to the database.
 */

package com.capstone.ShowSeek.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.capstone.ShowSeek.validation.EmailUnique;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateUserForm {

	@NotEmpty(message = "First name is required.")
	@Length(max = 45, message = "First name must be less than 45 characters.")
	private String firstName;

	@NotEmpty(message = "Last name is required.")
	@Length(max = 45, message = "Last name must be less than 45 characters.")
	private String lastName;

	@EmailUnique(message = "A user with this email already exists.")
	@NotEmpty(message = "Email is required.")
	@Length(max = 100, message = "Email must be less than 100 characters.")
	private String email;

	@NotEmpty(message = "Password is required.")
	@Length(max = 100, message = "Password must be less than 100 characters.")
	@Length(min = 8, message = "Password must be at least 8 characters.")
	private String password;

	@NotEmpty(message = "Confirm Password is required.")
	private String confirmPassword;

	@Length(max = 10, message = "Phone must be less than 10 characters.")
	private String phone;

	@NotNull(message = "Zip Code is required.")
	private Integer zip;

}
