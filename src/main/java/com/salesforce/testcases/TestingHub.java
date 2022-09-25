package com.salesforce.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingHub {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		RemoteWebDriver driver  = new RemoteWebDriver(new URL("http://192.168.1.4:4444"), capabilities);
		driver.get("https://login.salesforce.com/");

	}

}
