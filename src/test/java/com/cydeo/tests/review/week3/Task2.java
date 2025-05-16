package com.cydeo.tests.review.week3;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Task2 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testName1() {
        //TC 2: Alert practice
        // 1. Open browser
        // 2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");
        driver
                .findElement(By.xpath("//button[.='Click for JS Prompt']"))
                .click();

        // 3. Click to “Click for JS Prompt” button
        // 4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        // 5. Click to OK button from the alert
        alert.accept();
        // 6. Verify “You entered: hello” text is displayed.
        WebElement text = driver.findElement(By.id("result"));
        Assert.assertTrue(text.isDisplayed());
        BrowserUtils.sleep(3);
       /* String actual = text.getText();
        String expected = "You entered: hello";
        Assert.assertEquals(actual, expected);*/

    }
}
