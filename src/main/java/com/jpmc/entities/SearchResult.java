package com.jpmc.entities;

import org.openqa.selenium.WebElement;

public abstract class SearchResult {

	String headlineText;
	String sourceUrl;

	public String getHeadlineText() {
		return headlineText;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public abstract void setHeadlineText(WebElement searchResult);

	public abstract void setSourceUrl(WebElement searchResult);

}
