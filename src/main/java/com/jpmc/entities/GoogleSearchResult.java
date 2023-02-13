package com.jpmc.entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class GoogleSearchResult extends SearchResult {

	private static final String UNABLE_TO_DETERMINE_THE_SOURCE_OF_NEWS = "Unable to determine the source of news";
	private static final String SOURCE_DELIMITER = " > ";
	private static final String SEARCH_SOURCE_LOCATOR = "//a/div/cite";
	private static final String SEARCH_TITLE_LOCATOR = "h3";
	Logger log = LogManager.getLogger(GoogleSearchResult.class);

	@Override
	public void setHeadlineText(WebElement searchResult) {
		this.headlineText = searchResult.findElement(By.tagName(SEARCH_TITLE_LOCATOR)).getText();

	}

	@Override
	public void setSourceUrl(WebElement searchResult) {
		try {
			this.sourceUrl = searchResult.findElement(By.xpath(SEARCH_SOURCE_LOCATOR)).getText().split(SOURCE_DELIMITER)[0].trim();
		} catch (NoSuchElementException e) {
			log.warn(UNABLE_TO_DETERMINE_THE_SOURCE_OF_NEWS);
		}
	}

}
