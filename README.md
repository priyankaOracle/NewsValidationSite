❓ What is this Repository about?
This repository contains the code for running automation tests for web using cucumber.

Following are the details of Application Under Test :
Application under Test: https://www.theguardian.com/tone/news

Following are the steps that are automated :
Steps:
Navigate to https://www.theguardian.com/tone/news
Open the application in web browser.
Read the first index news headline from the guardian website.
Go to Google and Search the news headline saved from the guardian website.
Find number of matching articles with similar headline with matching accuracy %
Verify that the news is fake/real using criteria : Minimum required supporting articles 

Tech Stack used:
Programming Language: Java
Test Framework: Cucumber, Selenium WebDriver

Framework is governed by a configurable 'configuration.properties' file which is present at this location : 'NewsValidationSite/src/test/resources/configuration.properties'.
Config file contains parameters namely url, timeout, browser and executionmode.
url : This attribute supplies the url details to be launched. 
timeout : Specifies the maximum amount of time, in seconds, that the J2EE server waits for an application transaction that is propagated into this server to complete.
browser : This parameter has values such as Chrome, Firefox, Safari and Edge. It is currently configurable for Chrome browser.
executionmode : This parameter can be configured with two values namely local and pipeline. If the tests are executed with 'pipeline' execution mode, the test case would run headless and with head in the 'local' mode. 


How to Run the Tests
Right click on the Test Runner file present under /NewsValidationSite/src/test/java/com/jpmc/runners/TestRunner.java and Run as TestNG
