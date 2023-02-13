package com.jpmc.pageobjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.jpmc.entities.GoogleSearchResult;
import com.jpmc.entities.SearchResult;
import com.jpmc.utilities.NavigationUtils;
import com.jpmc.utilities.Wait;

public class GooglePage {

	static Logger log = LogManager.getLogger(NewsPage.class);

	private static final String HTTPS_WWW_GOOGLE_COM = "https://www.google.com";

	public GooglePage(WebDriver webDriver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
	}

	@FindBy(xpath = "//*[text()='Accept all']")
	private WebElement acceptCookies;

	@FindBy(name = "q")
	private WebElement googleSearchTextBox;

	@FindBy(xpath = "//*[@class='yuRUbf']")
	private List<WebElement> searchResults;

	@FindBy(xpath = "(//*[@class='yuRUbf']/a/h3)[1]")
	private WebElement searchResult;

	private void acceptCookies() {
		log.debug("---Handle the cookie popup on Google site---");
		acceptCookies.isDisplayed();
		acceptCookies.isEnabled();
		acceptCookies.click();
		log.debug("---The cookie popup on Google site is now handled---");
	}

	public void navigateToGoogle(WebDriver driver) {
		log.debug("---Navigate to google.com and accept cookies in google---");
		NavigationUtils.goToUrl(driver, HTTPS_WWW_GOOGLE_COM);
		acceptCookies();
		log.debug("---Navigated to google.com and accepted cookies in google---");
	}

	public void searchQuery(WebDriver webDriver, String query) {
		log.debug("---Search headline on google search text box---");
		googleSearchTextBox.isDisplayed();
		googleSearchTextBox.sendKeys(query);
		googleSearchTextBox.submit();
		Wait.untilElementIsVisible(webDriver, searchResult, Duration.ofSeconds(5), "searchResult");
		log.debug("---Headline on google search text box has been submitted---");
	}

	public List<SearchResult> getSearchResults() {
		log.debug("---Fetch the news headlines from google---");
		List<SearchResult> results = new ArrayList<>();
		searchResults.forEach(searchResult -> {
			GoogleSearchResult googleSearchResult = new GoogleSearchResult();
			googleSearchResult.setHeadlineText(searchResult);
			googleSearchResult.setSourceUrl(searchResult);
			results.add(googleSearchResult);
		});
		log.debug("---Fetched the list of news headlines from google---");
		return results;
	}

}
