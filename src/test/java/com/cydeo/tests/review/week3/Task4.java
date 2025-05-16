package com.cydeo.tests.review.week3;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Task4 {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }
    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void testName1() {
        // TC 4: Windows handle practice
        //    1. Open browser
        //    2. Go to website: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");
        //    3. Click on New Tab button
        driver.findElement(By.xpath("//button[.='New Tab']"));
        BrowserUtils.sleep(3);

        System.out.println(driver.getCurrentUrl());


        String currentTabId = driver.getWindowHandle();
        Set<String> allTabIds = driver.getWindowHandles();

        System.out.println("currentTabId = " + currentTabId);

        System.out.println("-----------------");

        System.out.println(allTabIds);

        switchToWindowWithTitle(allTabIds, "sample", driver);

        BrowserUtils.sleep(2);
        System.out.println(driver.getCurrentUrl());

        //    4. Click on New Window button
        //    5. Click on New Window Message button
        //    6. Print out each window title
    }
    public void switchToWindowWithTitle(Set<String> handles, String title, WebDriver driver) {

        for (String eachTabId : handles) {
            driver.switchTo().window(eachTabId);
            String currentTitle = driver.getTitle();
            if (currentTitle.contains(title)) {
                break;
            }
        }
    }

}
