package com.webform.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webform.base.BasePage;
import com.webform.pages.FormHomePage;

import io.qameta.allure.Feature;

public class FormPageFunctionTest extends BasePage {

    private FormHomePage formHomePage;

    @BeforeMethod
    public void setupPage() {
        formHomePage = new FormHomePage(getDriver());
    }

    @Test
    @Feature("User form submission")
    public void verifyValidFormSubmission() {
        formHomePage.submitSimpleForm("testName", "testPassword");
        Assert.assertTrue(formHomePage.isFormSubmitted(), "Success message is visible");
        staticWait(2);
    }

}
