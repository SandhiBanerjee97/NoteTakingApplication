package com.sandhi.domain;

import javax.validation.constraints.Email;

public class EmailDto
{
	@Email(message = "* Please enter a valid email")
	private String userEmail;
	public String getUserEmail() 
	{
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
