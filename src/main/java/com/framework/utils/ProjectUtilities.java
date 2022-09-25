package com.framework.utils;

public class ProjectUtilities{
	
	public String extractUserName(String email) {
		
		return email.split("@").toString();

	}

}
