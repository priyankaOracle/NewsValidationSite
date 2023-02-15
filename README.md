**What is this Repository about?**  
This is a UI automation framework based on Selenium WebDriver (from Selenium 4) and JAVA (JDK 8) integrated with Cucumber and TestNG.
It has been developed to validate the news article authenticity on a news website by searching the newes headline keywords on a search engine and verify the presence of other similar articles over the internet.

**Understanding of the problem**  
According to the problem statement, the eventual goal of this framework is to determine whether a news article (currenlty on www.guardian.com) is real or fake by searching for similar article of other search platforms (currently Google).
In order to achive this goal, the test scenarios are performing the below steps:  
1. Open the Guardian new page.  
2. Read the text of the first news article (index of the news article is configurable)
3. Sanitize the captured headline string (Sanitize means remooving unwanted words which does not change the meaning of the sentence)
4. Open Google.com
5. Search for the sanitized headline string (from step 3)
6. Match the Google search results (only first page for now) with the sanitized headline string with pre-defined accuracy(Accuracy percent can be configured).
7. Verify minimum required articles are found in the search results (minimum required articles can be configured)   
NOTE : Accuracy is a configurable parameter (Refer scenario example in the feature file). This parameter defines how much matching percentage is required between the news headline(source) and searched articles on google (target) in order to qualify the article on internet (google) as "similar" to the source headline.


**Tech Stack**  
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
  
This frameworks also supports screenshots on  success and failure scenarios. The report location can be found at :
  <root>/main/target/cucumber-reports/advanced-reports/cucumber-html-reports

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
           
**Logging** 
This framework is powered by the Log4j2 logging capabilities. The logging is configured to append the logs both on console and in a file. The log file can be found at <root>/application.log  

**Details of automated scenarios**  
I have used the capability of Cucumber 'Examples' to automate multiple scenarios with different inputs in one single scenario outline. Below is the template of the scenario outline:  

Navigate to https://www.theguardian.com/tone/news  
Open the application in web browser.  
Read the first index news headline from the guardian website.  
Go to Google and Search the news headline saved from the guardian website.  
Find number of matching articles with similar headline with matching accuracy percentage  
Verify that the news is fake/real using criteria : Minimum required supporting articles   
