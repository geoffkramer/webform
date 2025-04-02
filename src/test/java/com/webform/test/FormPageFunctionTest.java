package com.webform.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webform.base.BasePage;
import com.webform.pages.FormHomePage;

import io.qameta.allure.Feature;

public class FormPageFunctionTest extends BasePage {

    private FormHomePage formHomePage;
    private Properties properties; 

    @BeforeMethod
    public void setupPage() {
        formHomePage = new FormHomePage(getDriver());
        properties = loadProperties();
    }

     private Properties loadProperties() {
        Properties prop = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("can't find properties");
                return null;
            }
            prop.load(input);
        } catch (IOException ex) {
            System.out.println("error");
        }
        return prop;
    }

    @Test
    @Feature("User form submission")
    /*  dynamic usage of username and password, this would be more useful for larger
     and more complex systems and stops hardcoding potentially sensistive credentials in the test*/
    public void verifyValidFormSubmission() {
        String username = properties.getProperty("formUsername");
        String password = properties.getProperty("formPassword");

        formHomePage.submitSimpleForm(username, password);
        Assert.assertTrue(formHomePage.isFormSubmitted(), "Success message is visible");
        staticWait(2);
    }

}
