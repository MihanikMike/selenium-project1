package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T5_WindowsPractice {

    WebDriver driver;
//    TC #5: Window Handle practice
//    1. Create a new class called: T5_WindowsPractice
//    2. Create new test and make set ups
//    3. Go to : https://practice.cydeo.com/windows

//    5. Click to: “Click Here” link
//    6. Switch to new Window.
//    7. Assert: Title is “New Window”
    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/windows");

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @Test
    public void multiple_windows_test(){
        //    4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);
        System.out.println("Title before click: " + driver.getTitle());

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        System.out.println("Title after click: " + driver.getTitle());

        for (String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());
        }

        String expectedTitleAfterClick = "New Window";
        actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitleAfterClick);

    }

}
