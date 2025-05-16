package com.cydeo.tests.day9_review_javafaker_driverUtil;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC1 {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void testBing_search() {

//        1- Open a chrome browser
//        2- Go to: https://bing.com
        driver.get(ConfigurationReader.getProperty("bingURL"));
//        3- Write “apple” in search box
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@name='q']"));
        BrowserUtils.sleep(3);
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue2") + Keys.ENTER);
//        4- Verify title:
//        Expected: apple - Search
        BrowserUtils.verifyTitle(driver, ConfigurationReader.getProperty("searchValue2") + " - Search");

    }
}

