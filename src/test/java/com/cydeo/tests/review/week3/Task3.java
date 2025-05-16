package com.cydeo.tests.review.week3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task3 {
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
        //TC 3: Iframe practice
        // 1. Open browser
        // 2. Go to https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");
        // 3. Click Frames link
        WebElement ele = getWebelement("Frames", driver);
        ele.click();
        // 4. Click Nested Frames link
        getWebelement("Nested Frames", driver).click();
        // 5. Verify MIDDLE text is visible
        driver.switchTo().frame(0); // look at the top
        driver.switchTo().frame(1); // look at the first frame
        String text = driver.findElement(By.xpath("//body")).getText();
        System.out.println(text);

        Assert.assertEquals(text, "MIDDLE");


    }

    private WebElement getWebelement(String text, WebDriver driver){
        String locator = "//a[.='"+text+"']";
        return driver.findElement(By.xpath(locator));
    }
}
