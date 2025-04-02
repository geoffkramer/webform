package com.webform.test;

import org.testng.annotations.Test;

import com.webform.base.BasePage;



public class LaunchSiteTest extends BasePage {

    @Test
    public void launchSite() {
        //Launch site and assert the title is Web form
        String title = driver.getTitle();
        assert title.equals("Google") : "test failed - title isn't correct";

        System.out.println("test passed - title is matching");
    }


}
