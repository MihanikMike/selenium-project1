package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC8 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

//        TC #8: Selecting value from non-select dropdown
//        1. Open Chrome browser
//        2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

    @Test
    public void selectingState() throws InterruptedException {
        //        3. Click to non-select dropdown
        driver.findElement(By.id("dropdownMenuLink")).click();
        Thread.sleep(2000);
        //        4. Select Facebook from dropdown
        driver.findElement(By.linkText("Facebook")).click();
        Thread.sleep(2000);
        //        5. Verify title is “Facebook - Log In or Sign Up”
        String expectedTitle = "Facebook - log in or sign up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title are not equals");

    }

}
