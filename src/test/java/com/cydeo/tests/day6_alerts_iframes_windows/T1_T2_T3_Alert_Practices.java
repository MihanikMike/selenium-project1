package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_T2_T3_Alert_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/javascript_alerts");

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

    @Test
    public void alert_test1() {
        //    TC #1: Information alert practice
//    1. Open browser
//    2. Go to website: https://practice.cydeo.com/javascript_alerts
//    3. Click to “Click for JS Alert” button
//    4. Click to OK button from the alert
//    5. Verify “You successfully clicked an alert” text is displayed.
        WebElement informationAlertButton = driver.findElement(By.xpath(  "//button[ .= 'Click for JS Alert']"));
        informationAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT displayed!");

        String expectedText = "You successfully clicked an alert";
        String actualText = resultText.getText();
        Assert.assertEquals(actualText,expectedText);

    }

    @Test
    public void confirmAlert(){
//        TC #2: Confirmation alert practice
//        1. Open browser
//        2. Go to website: http://practice.cydeo.com/javascript_alerts
//        3. Click to “Click for JS Confirm” button
        WebElement informationAlertButton = driver.findElement(By.xpath(  "//button[ .= 'Click for JS Confirm']"));
        informationAlertButton.click();
//        4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
//        5. Verify “You clicked: Ok” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT displayed!");
        String expectedText = "You clicked: Ok";
        String actualText = resultText.getText();
        Assert.assertEquals(actualText,expectedText);
    }

    @Test
    public void information_alert(){

//        TC #3: Information alert practice
//        1. Open browser
//        2. Go to website: http://practice.cydeo.com/javascript_alerts
//        3. Click to “Click for JS Prompt” button
        WebElement informationAlertButton = driver.findElement(By.xpath(  "//button[ .= 'Click for JS Prompt']"));
        informationAlertButton.click();
//        4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();
//        5. Click to OK button from the alert
//        6. Verify “You entered: hello” text is displayed
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT displayed!");
        String expectedText = "You entered: hello";
        String actualText = resultText.getText();
        Assert.assertEquals(actualText,expectedText);
    }

}
