package com.webform.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BasePage {

    protected static Properties prop;
    protected WebDriver driver;

    @BeforeSuite
    public void loadConfig() throws IOException {
        // load the config file
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        prop.load(fis);
    }

    @BeforeMethod
    public void setup() throws IOException {
        System.out.println("Setting up webdriver for:" + this.getClass().getSimpleName());
        launchBrowser();
        configureBrowser();
        staticWait(5);
    }

    private void launchBrowser() {
        // initialise web driver based on browser in config.properties
        String browser = prop.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void configureBrowser() {
        // Implicit wait
        int implicitWait = Integer.parseInt(prop.getProperty("implicitWait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

        // maximise driver window
        driver.manage().window().maximize();

        // navigate to url
        try {
            driver.get(prop.getProperty("url"));
        } catch (Exception e) {
            System.out.println("Failed to Navigate to site:" + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("unable to quit driver:" + e.getMessage());
            }
        }
    }

    // static wait for pausing
    public void staticWait(int seconds) {
        LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(seconds));
    }

}
