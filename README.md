❓ **What is this Repository about?**
This is a UI automation framework based on Selenium WebDriver (from Selenium 4) and JAVA (JDK 8) integrated with Cucumber and TestNG.
It has been developed to validate the news article authenticity on a news website by searching the newes headline keywords on a search engine and verify the presence of other similar articles over the internet.


**Tech Stack**:
Languages: Java, Gherkin
Libraries: Selenium WebDriver, Log4j2
Test Framework:TestNG
Tools: Cucumber
Build Tool: Maven

**Framework details**
Framework is governed by a configurable 'configuration.properties' file which is present at '<root>/src/test/resources/configuration.properties'.
Below are the parameters and their respective usage:
url : This parameter defines the URL of the news site to be tested. (See support matrix for currently supported news website URLs)
timeout : Specifies the maximum amount of time, in seconds, that the framework uses for waits.
browser : This parameter defines the browser to be used for testing. (See support matrix for currently supported browsers)
executionmode : This parameter can take two values:
  local: This is a developer mode in which the framework will open browser and all UI actions will be visible.
  pipeline: This is CI/CD or pipeline mode in which the framework will run in 'headless' fashion.

**Support Matrix**
News Website URLs: https://www.theguardian.com/tone/news
Search Engines: www.google.com
Browsers: chrome and firefox

**How to Run the Tests**
Tests can be run in two ways:
  1. CLI: In the terminal run
      mvn clean install
  2. IDE: 
    i) Import the project in an IDE as a maven project
    ii) Right click on the Test Runner file present under <root>/src/test/java/com/jpmc/runners/TestRunner.java and Run as TestNG

**Details of automated scenarios**

Steps:
Navigate to https://www.theguardian.com/tone/news
Open the application in web browser.
Read the first index news headline from the guardian website.
Go to Google and Search the news headline saved from the guardian website.
Find number of matching articles with similar headline with matching accuracy %
Verify that the news is fake/real using criteria : Minimum required supporting articles 
