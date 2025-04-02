# webform
This readme file is designed to explain what is / should be happening, and what intentions were moving forward 

- The design pattern is POM

- a simple test (LaunchSiteTest.java) was written to ensure the site would launch, this may be left in and used as a benchmark.

- Objects stored in pages/XPage.java files 

- Tests stored / ran in test/java/com/webform/test XTest.java files

- config.properties is where any useful information is stored and then pulled from for Before / After classes etc. such as url, implicitWait, name, password etc. 

- ActionDriver class is where scrolling, clicking etc. is stored

- BasePage.java initialises the webdriver, and has teardown for after the test has finished. 

- Implement cucumber tests using feature files in the following format making it more readable: 
    - As a web form user ...  
    - I want to add my details ... 
    - So I can ... 

- I would want to implement more verbose reporting - ideally creating an allure report after tests have been run - displaying number of tests ran, and % passed and failed, with a breakdown of each test, the point of failure i.e. "can't find X object", and a screenshot where necessary. 
The following exists in the debug console for now: 
===============================================
Default Suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================



- TO RUN THE TESTS 
    - Navigate to the project root dir and run 'mvn clean test' without the apostrophes. 

