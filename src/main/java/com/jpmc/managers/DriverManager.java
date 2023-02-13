package com.jpmc.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.jpmc.constants.BrowserConstants;
import com.jpmc.enums.DriverType;
import com.jpmc.enums.ExecutionMode;

public class DriverManager {

	private WebDriver webDriver;
	private static DriverType driverType;
	private static ExecutionMode executionMode;

	public DriverManager() {
		driverType = ConfigManager.getInstance().getConfigFileReader().getBrowser();
		executionMode = ConfigManager.getInstance().getConfigFileReader().getEnvironment();
	}

	private WebDriver createDriver() {
		switch (driverType) {
		case CHROME:
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments(BrowserConstants.WINDOW_SIZE);
			if (executionMode.equals(ExecutionMode.PIPELINE)) {
				chromeOptions.addArguments(BrowserConstants.HEADLESS);
			}
			webDriver = new ChromeDriver(chromeOptions);
			break;
		case FIREFOX:
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments(BrowserConstants.WINDOW_SIZE);
			if (executionMode.equals(ExecutionMode.PIPELINE)) {
				firefoxOptions.addArguments(BrowserConstants.HEADLESS);
			}
			webDriver = new FirefoxDriver(firefoxOptions);
			break;

		}
		return webDriver;
	}

	public WebDriver getDriver() {
		if (webDriver == null)
			webDriver = createDriver();
		return webDriver;
	}

	public void closeDriver() {
		webDriver.close();
		webDriver.quit();
	}
}
