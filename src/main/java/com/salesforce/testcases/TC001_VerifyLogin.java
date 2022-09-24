package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.LoginPage;

public class TC001_VerifyLogin extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "VerifyLogin";
		testDescription ="Verify Login functionality with positive data";
		authors="Narendran";
		category ="Smoke";
		excelFileName="Login";
		//rg new comment added for resolving conflict
	}
		
	@Test(dataProvider = "fetchData")
	public void runLogin(String username, String password) {
		
		// login testcase
		
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.verifyHomePage();
//end of method runLogin
	}

}
