package com.salesforce.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods{
	//adding comment for triparty commit rg change for soundariya 1
	public LoginPage enterUsername(String data) {
		
		clearAndType(locateElement(Locators.ID, "username"), data);
		reportStep(data+" entered successfully","pass");
		return this;
		// new comment
	}
	
	public LoginPage enterPassword(String data) {
		// enter Password method
		clearAndType(locateElement(Locators.ID, "password"), data);
		reportStep(data+" entered successfully","pass");
		return this;
		
	}
	
	public HomePage clickLogin() {
		click(locateElement(Locators.ID, "Login"));
		reportStep("Login button clicked successfully", "pass");
		return new HomePage();
	}
	
	// rg change for soundariya commit 3

}//code ends here commit 4
