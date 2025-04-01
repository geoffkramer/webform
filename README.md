# webform
This readme file is designed to explain what is / should be happening, and what intentions were moving forward 

- The design pattern is POM
- a dummy test (Dummyclass.java) was written to ensure the test would launch - currently tests need to be run individually, "mvn clean test" does not launch a browser yet. 
- Intention is to have objects stored in src/main/java/pages, that can then be called and used in tests. 
- config.properties is where any useful information is stored and then pulled from for Before / After classes etc. 

- I would then develop cucumber tests in the format, making it more readable: 
    - As an X 
    - I want to Y
    - So I can Z 

- BasePage.java initialises the webdriver, and has teardown for after the test has finished. 
- I would want to implement more verbose reporting, creating an allure report after tests have been run, displaying number of tests ran, and % passed and failed, with a breakdown of each test, the point of failure i.e. "can't find X object", and a screenshot where necessary. 
The following exists in the debug console for now: 
===============================================
Default Suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================

- actiondriver is where functions like scrolling would be added 

