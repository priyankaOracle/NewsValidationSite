package com.jpmc.utilities;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jpmc.exceptions.NewsValidationElementNotVisibleException;

public class Wait {

	static Logger log = LogManager.getLogger(Wait.class);

	public static void untilElementIsVisible(WebDriver webDriver, WebElement webElement, Duration timeOutInSeconds,
			String elementName) {
		log.debug("---Waiting for visibilityOf:{}---", elementName);
		try {
			new WebDriverWait(webDriver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(webElement));
		} catch (Exception e) {
			log.error("Exception occurred while waiting for element: {}", elementName);
			throw new NewsValidationElementNotVisibleException(e);
		}
		log.debug("---{} is visible ---", elementName);
	}

}
