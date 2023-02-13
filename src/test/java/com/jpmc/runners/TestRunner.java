package com.jpmc.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.jpmc.utilities.StringUtils;

@CucumberOptions(
        features = "src/test/resources/com/jpmc/features/ValidateNews.feature",
        glue = "com.jpmc.stepdefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "timeline:target/test-output-thread/"
    }
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	static final Logger log = LogManager.getLogger(StringUtils.class);

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeSuite
    public void beforeSuite() {
    	log.debug(("================ BEFORE SUITE ================"));
    }

    @AfterSuite
    public void afterSuite() {
    	log.debug(("================ AFTER SUITE ================"));
    }
}
