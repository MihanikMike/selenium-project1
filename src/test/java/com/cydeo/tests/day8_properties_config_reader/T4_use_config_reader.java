package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_use_config_reader {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void google_search_test() {
//        1- Open a chrome browser
//        2- Go to: https://google.com
        driver.get(ConfigurationReader.getProperty("amazonURL"));
//        3- Write “apple” in search box
        driver.navigate().refresh();
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='field-keywords']"));
        BrowserUtils.sleep(3);
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);
//        4- Verify title:
//        Expected: apple - Google Search
//        Use `configuration.properties` for the following:
        BrowserUtils.sleep(3);
        String expectedTitle = "Amazon.com : " + ConfigurationReader.getProperty("searchValue");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
//        1. The browser type
//        2. The URL
//        3. The search keyword
//        4. Make title verification dynamic. If search value changes, title
//        assertion should not fail.
    }
}
