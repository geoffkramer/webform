package com.webform.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webform.base.BasePage;
import com.webform.pages.FormHomePage;

public class FormPageFunctionTest extends BasePage {

    private FormHomePage formHomePage;

    @BeforeMethod
    public void setupPage() {
        formHomePage = new FormHomePage(getDriver());
    }

    @Test
    public void verifyValidFormSubmission() {
        formHomePage.submitSimpleForm("testName", "testPassword");
        Assert.assertTrue(formHomePage.isFormSubmitted(), "Success message is visible");
        staticWait(2);
    }

}
