package com.jpmc.pageobjects;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jpmc.utilities.Wait;

public class NewsPage {
	
	static Logger log = LogManager.getLogger(NewsPage.class);

	public NewsPage(WebDriver webDriver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
	}

	@FindBy(css = ".message-button:first-of-type")
	private WebElement yesIAmHappy;

	@FindBy(xpath = "//*[@title='The Guardian consent message']")
	private WebElement guardianIframe;

	@FindBy(css = ".index-page-header .index-page-header__title")
	private WebElement headerNewsTitle;

	@FindBy(css = ".fc-slice__item .fc-item__headline")
	private List<WebElement> headLines;

	public String getHeadLineTextByIndex(int index) {
		return headLines.get(index - 1).getText();
	}

	public boolean defaultNewsPageIsDisplayed() {
		log.debug("---Verify the Guardian News page is displayed---");
		headerNewsTitle.isDisplayed();
		log.debug("---The Guardian News page is being displayed---");
		return true;
	}

	public void handleCookiePopup(WebDriver webDriver) {
		log.debug("---Handle the cookie popup on Guardian News site---");
		WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
		webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(guardianIframe));
		Wait.untilElementIsVisible(webDriver, yesIAmHappy, Duration.ofSeconds(3), "acceptCookie");
		yesIAmHappy.click();
		log.debug("---The cookie popup on Guardian News site is now handled---");

	}

}
