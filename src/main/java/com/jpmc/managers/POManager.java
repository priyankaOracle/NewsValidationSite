package com.jpmc.managers;

import org.openqa.selenium.WebDriver;

import com.jpmc.pageobjects.GooglePage;
import com.jpmc.pageobjects.NewsPage;

public class POManager {

	private final WebDriver webDriver;
	private NewsPage newsPage;
	private GooglePage googlePage;

	public POManager(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public NewsPage getNewsPage() {
		return (newsPage == null) ? newsPage = new NewsPage(webDriver) : newsPage;
	}

	public GooglePage getGooglePage() {
		return (googlePage == null) ? googlePage = new GooglePage(webDriver) : googlePage;
	}
}
