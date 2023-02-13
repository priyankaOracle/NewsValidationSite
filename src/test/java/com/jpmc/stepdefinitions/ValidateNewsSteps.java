package com.jpmc.stepdefinitions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.jpmc.entities.SearchResult;
import com.jpmc.enums.Context;
import com.jpmc.managers.ConfigManager;
import com.jpmc.pageobjects.GooglePage;
import com.jpmc.pageobjects.NewsPage;
import com.jpmc.utilities.StringUtils;
import com.jpmc.utilities.TestCtx;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidateNewsSteps {

	NewsPage newsPage;
	TestCtx testContext;
	GooglePage googlePage;
	String headLine;
	List<SearchResult> searchResults;
	Logger log = LogManager.getLogger(Hooks.class);

	public ValidateNewsSteps(TestCtx context) {
		testContext = context;
		newsPage = testContext.getPageObjectManager().getNewsPage();
		googlePage = testContext.getPageObjectManager().getGooglePage();
	}

	@Given("News Validation Site is open")
	public void newsValidationSiteIsOpen() {
		log.debug("---Open news Validation site and handle cookie popup---");
		newsPage.handleCookiePopup(testContext.getDriverManager().getDriver());
		Assert.assertTrue(newsPage.defaultNewsPageIsDisplayed());
		log.debug("---Verify that news Validation site is successfully open---");
	}

	@Given("Read the {int} news headline")
	public void readTheNewsHeadLineByIndex(int index) {
		log.debug("---Read the first news from the News Validation Site and store the headline text---");
		headLine = StringUtils.sanitizeString(newsPage.getHeadLineTextByIndex(index));
		Assert.assertTrue(headLine.length() > 0);
		testContext.scenarioContext.setContext(Context.HEADLINE, headLine);
		log.debug("---Verify that the first news headline from the news validation site gets stored ---");
	}

	@When("Open google and search news headline")
	public void openGoogleAndSearchNewsHeadline() {
		log.debug("---Search matching headline text in google.com ---");
		googlePage.navigateToGoogle(testContext.getDriverManager().getDriver());
		String headLine = testContext.scenarioContext.getContext(Context.HEADLINE).toString();
		googlePage.searchQuery(testContext.getDriverManager().getDriver(), headLine);
		searchResults = googlePage.getSearchResults();
		Assert.assertNotNull(searchResults);
		log.debug("---Verify that that matching headlines search results are displayed on google ---");
	}

	@When("Find number of matching articles with similar headline with matching accuracy of {int} %")
	public void findNumberOfMatchingArticlesWithSimilarHeadlineMatchingAccuracyOf(Integer accuracy) {
		log.debug("---Find number of matching articles with similar headlines with matching accuracy---");
		int newsCountMatch = 0;
		log.debug("---Filter out all search results from the site under test and exclude guardian news search result---");
		String siteUrl = ConfigManager.getInstance().getConfigFileReader().getUrl();
		searchResults.stream().filter(res -> !res.getSourceUrl().contains(siteUrl));
		for (SearchResult searchResult : searchResults) {
			Double matchPercent = StringUtils.getMatchPercent(headLine,
					StringUtils.sanitizeString(searchResult.getHeadlineText()));
			if (matchPercent > accuracy) {
				newsCountMatch++;
			}
		}
		testContext.scenarioContext.setContext(Context.NEWS_COUNT, newsCountMatch);
		log.debug("---Verify that the matching articles count is found---");

	}

	@Then("Verify the news is fake using criteria: Minimum required supporting articles {int}")
	public void verifyTheNewsIsFakeUsingCriteriaMinimumRequiredSupportingArticles(Integer minRequiredArticles) {
		log.debug("---Verify the news is fake using criteria: Minimum required supporting articles {int} ---");
		Assert.assertFalse(Integer.parseInt(
				testContext.scenarioContext.getContext(Context.NEWS_COUNT).toString()) >= minRequiredArticles);
		log.debug(
				"---Verified that the the news is fake based on the criteria of Minimum required supporting articles {int} ---");

	}

	@Then("Verify the news is real using criteria: Minimum required supporting articles {int}")
	public void verifyTheNewsIsRealUsingCriteriaMinimumRequiredSupportingArticles(Integer minRequiredArticles) {
		log.debug("---Verify the news is real using criteria: Minimum required supporting articles {int} ---");
		Assert.assertTrue(Integer.parseInt(
				testContext.scenarioContext.getContext(Context.NEWS_COUNT).toString()) >= minRequiredArticles);
		log.debug(
				"---Verified that the the news is fake based on the criteria of Minimum required supporting articles {int} ---");

	}
}
