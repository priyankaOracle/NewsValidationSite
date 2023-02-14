❓ What is this Repository about?
This repository contains the code for running automation test for web using cucumber.

Following are the details of Application Under Test
Application under Test: https://www.theguardian.com/tone/news
Following are the steps that are automated as an example
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

How to Run the Tests
Right click on the Test Runner file present under /NewsValidationSite/src/test/java/com/jpmc/runners/TestRunner.java and Run as TestNG
