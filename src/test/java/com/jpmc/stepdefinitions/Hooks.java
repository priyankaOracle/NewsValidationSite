package com.jpmc.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.jpmc.exceptions.NewsValidationWebDriverException;
import com.jpmc.managers.ConfigManager;
import com.jpmc.utilities.TestCtx;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	TestCtx testContext;
	WebDriver webDriver;
	Logger log = LogManager.getLogger(Hooks.class);

	public Hooks(TestCtx context) {
		testContext = context;
	}

	@Before
	public void setUp() {
		log.debug("---Set up of webdriver---");
		webDriver = testContext.getDriverManager().getDriver();
		webDriver.get(ConfigManager.getInstance().getConfigFileReader().getUrl());
		webDriver.manage().window().maximize();
		log.debug("---Set up is complete---");
	}

	@After
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {

			try {
				log.debug("Scenario failed : {}", scenario.getName());
				byte[] screenshot = ((TakesScreenshot) testContext.getDriverManager().getDriver())
						.getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "screenshot");
			} catch (WebDriverException e) {
				throw new NewsValidationWebDriverException(e);
			}
		}

		else {
			try {
				log.info("Scenario passed : {}", scenario.getName());
				byte[] screenshot = ((TakesScreenshot) testContext.getDriverManager().getDriver())
						.getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "screenshot");
			} catch (WebDriverException e) {
				throw new NewsValidationWebDriverException(e);
			}
		}
		testContext.getDriverManager().closeDriver();
	}
}
