package com.framework.testng.api.base;

import com.framework.selenium.api.design.Locators;
import com.salesforce.pages.HomePage;
import com.salesforce.pages.LoginPage;

public class CommonBusinessMethods extends ProjectSpecificMethods{
	
	public HomePage login() {
		
		return new LoginPage()
		.enterUsername("")
		.enterPassword("")
		.clickLogin();

	}
	
	public HomePage testMethod(String data) {
		
		clearAndType(locateElement(Locators.ID, "username"), data);
		reportStep(data+" entered successfully","pass");
		return new HomePage();

	}

}
