package com.webform.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webform.actiondriver.ActionDriver;

public class FormHomePage {

    private ActionDriver actionDriver;

    // Define locators / selectors using By

    private By textInputField = By.name("my-text");
    private By passWordField = By.name("my-password");
    private By submitButton = By.cssSelector("button[type='submit']");
    private By formSubmittedMessage = By.xpath("//h1[text()='Form submitted']");

    // Initialise ActionDriver object by passing webDriver
    public FormHomePage(WebDriver driver) {
        this.actionDriver = new ActionDriver(driver);
    }

    // submit simple form with name and password only
    public void submitSimpleForm(String userName, String password) {
        actionDriver.enterText(textInputField, userName);
        actionDriver.enterText(passWordField, password);
        actionDriver.click(submitButton);
    }

    // Check the form was submitted successfully
    public boolean isFormSubmitted() {
        return actionDriver.isDisplayed(formSubmittedMessage);
    }

    // Check if the success is correct or not
    public void verifySuccessMessage(String expectedSuccess) {
        actionDriver.compareTextValues(formSubmittedMessage, expectedSuccess);
    }

}
