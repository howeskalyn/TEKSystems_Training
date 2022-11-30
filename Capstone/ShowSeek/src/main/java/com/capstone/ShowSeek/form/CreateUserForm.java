package com.capstone.ShowSeek.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateUserForm {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
	private String phone;
	private String zip;
	

}
