package com.framework.selenium.api.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverInstance {

	private static final ThreadLocal<RemoteWebDriver> remoteWebdriver = new ThreadLocal<RemoteWebDriver>();
	private static final ThreadLocal<WebDriverWait> wait = new ThreadLocal<WebDriverWait>();

	public void setWait() {
		wait.set(new WebDriverWait(getDriver(), 30));
	}

	public WebDriverWait getWait() {
		return wait.get();
	}

	public void setDriver(String browser, boolean headless) throws MalformedURLException {
		switch (browser) {
		case "chrome":
			String username = System.getenv("LT_USERNAME") == null ? "discovernaren" : System.getenv("LT_USERNAME");
			String authkey = System.getenv("LT_ACCESS_KEY") == null
					? "wZyOeP1rGmGHH67md39L1Ii8uDK5eK4wNnShfFyLYQlTAfGiXv"
							: System.getenv("LT_ACCESS_KEY");
			String hub = "@hub.lambdatest.com/wd/hub";
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			options.addArguments("--incognito");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName("chrome");
			// remoteWebdriver.set(new ChromeDriver(options)); local 
			// remoteWebdriver.set(new RemoteWebDriver(new URL("http://192.168.1.4:4444"), capabilities)); hub node
			remoteWebdriver.set(new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), capabilities));
			break;
		case "firefox":
			remoteWebdriver.set(new FirefoxDriver());
			break;
		case "ie":
			remoteWebdriver.set(new InternetExplorerDriver());
		default:
			break;
		}
	}

	public RemoteWebDriver getDriver() {
		return remoteWebdriver.get();
	}

}
