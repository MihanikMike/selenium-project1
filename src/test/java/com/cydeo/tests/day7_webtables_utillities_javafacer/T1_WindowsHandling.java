package com.cydeo.tests.day7_webtables_utillities_javafacer;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_WindowsHandling {
    WebDriver driver;
//    1. Create new test and make set ups
//    2. Go to : https://www.amazon.com
//    3. Copy paste the lines from below into your class
//    4. Create a logic to switch to the tab where Etsy.com is open
//    5. Assert: Title contains “Etsy”
//    Lines to be pasted:
//      ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
//      ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
//      ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
//    These lines will simply open new tabs using something called JavascriptExecutor
//    and get those pages. We will learn JavascriptExecutor later as well.

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @Test
    public void windowsHandling() {
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        /*Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {
            driver.switchTo().window(each);
            System.out.println("Current URL: " + driver.getCurrentUrl());

            if(driver.getTitle().contains("etsy")) {
                break;
            }
        }
        String expectedTitle = "etsy";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));*/

        BrowserUtils.switchWindowAndVerify(driver, "etsy", "etsy");
        BrowserUtils.verifyTitle2(driver,"etsy");
    }

}

