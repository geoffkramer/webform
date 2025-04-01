package com.webform.test;

import org.testng.annotations.Test;

import com.webform.base.BasePage;

public class Dummyclass extends BasePage {


@Test
public void dummyTest() {
    String title = driver.getTitle();
    assert title.equals("Web form"):"test failed - title isn't correct"; 

    System.out.println("test passed - title is matching");
}


}
