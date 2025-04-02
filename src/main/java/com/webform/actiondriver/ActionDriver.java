package com.webform.actiondriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webform.base.BasePage;

public class ActionDriver {

    private WebDriver driver;
    private WebDriverWait wait;

    public ActionDriver(WebDriver driver) {
        this.driver = driver;
        int explicitWait = Integer.parseInt(BasePage.getProp().getProperty("explicitWait"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
    }

    // Click an element
    public void click(By by) {
        try {
            waitForElementToBeClickable(by);
            driver.findElement(by).click();
        } catch (Exception e) {
            System.out.println(("unable to click element" + e.getMessage()));
        }
    }

    // Method to enter text into input field
    public void enterText(By by, String value) {
        try {
            waitForElementToBeVisible(by);
            WebElement element = driver.findElement(by);
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            System.out.println("Unable to enter text value into field" + e.getMessage());
        }
    }

    // Method to get text from an input field
    public String getTextMethod(By by) {
        try {
            waitForElementToBeVisible(by);
            return driver.findElement(by).getText();
        } catch (Exception e) {
            System.out.println("Unable to get text" + e.getMessage());
            return "";
        }
    }

    // Method to compare two text elements
    public void compareTextValues(By by, String expectedText) {
        try {
            waitForElementToBeVisible(by);
            String actualText = driver.findElement(by).getText();
            if (expectedText.equals(actualText)) {
                System.out.println("Text values match:" + actualText + "equals " + expectedText);
            } else {
                System.out.println("Text values do not match" + actualText + " does not equal " + expectedText);
            }
        } catch (Exception e) {
            System.out.println("Unable to compare text values");
        }
    }

    // Simplified method to check if an element is displayed
    public boolean isDisplayed(By by) {
        try {
            waitForElementToBeVisible(by);
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            System.out.println("Element is not displayed: " + e.getMessage());
            return false;
        }
    }

    // Wait for page to load
    public void waitForPageTooad(int timeOutInSec) {
        try {
            wait.withTimeout(Duration.ofSeconds(timeOutInSec)).until(WebDriver -> ((JavascriptExecutor) WebDriver)
                    .executeScript("return document.readyState").equals("complete"));
            System.out.println("page loaded successfully");
        } catch (Exception e) {
            System.out.println("Page didn't load within " + timeOutInSec + " seconds. Exception: " + e.getMessage());
        }
    }

    // Scroll to element
    public void scrollToElement(By by) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement element = driver.findElement(by);
            js.executeScript("arguments[0],scrollIntoView(true);", element);
        } catch (Exception e) {
            System.out.println("could not scroll to element " + e.getMessage());
        }
    }

    // Wait for element to be clickable
    private void waitForElementToBeClickable(By by) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            System.out.println("element is not clickable" + e.getMessage());
        }
    }

    // Wait for element to be visible
    private void waitForElementToBeVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            System.out.println("element is not visible" + e.getMessage());
        }
    }

}
