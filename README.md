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

- Allure reports now added, however the below logging format is also present:

===============================================
Default Suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================



- TO RUN THE TESTS 
    - Navigate to the project root dir and run 'mvn clean test' without the apostrophes.
    - Ensure any tests you want to run have the @Test tag, this would be expanded on with @Feature, @Epic etc. based on the number of tests. 


- ALLURE REPORTS
    -  after running tests using mvn clean test
    - in terminal, run "mvn allure:report" to generate the report 
    - in terminal, run "mvn allure serve -p 8080 <path to target/allure-results>" this will launch a local server and display the test reports in an easy to read formate
        - usually it would be "mvn allure:serve" but this is causing some issues, likely with busy default port or java version discrepencies
    - Intention to add screenshots at the point of test failure


