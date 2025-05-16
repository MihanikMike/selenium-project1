package com.cydeo.tests.review.week3;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task1 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

    @Test
    public void test1() {
        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");
        // 3. Enter First name: "John"
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("John");
        // 4. Enter Last name: "Smith"
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Smith");
        // 5. Enter Username: "johnsmith123"
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("johnsmith123");
        // 6. Enter Email address: "john.smith@email.com"
        WebElement emailAddress = driver.findElement(By.xpath("//input[@name='email']"));
        emailAddress.sendKeys("john.smith@email.com");
        // 7. Enter password: "John1234"
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("John1234");
        // 8. Enter Phone number: "123-456-7890"
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys("123-456-7890");
        // 9. Click to "Male" from Gender
        WebElement radioButton = driver.findElement(By.xpath("//input[@value='male']"));
        radioButton.click();
        // 10. Enter Date of birth "01/28/1990"
        WebElement birthDate = driver.findElement(By.xpath("//input[@name='birthday']"));
        birthDate.sendKeys("01/28/1990");
        // 11. Select "Department of Engineering" from Department/Office dropdown
        Select selectDoE = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        selectDoE.selectByIndex(1);
        // 12. Select "SDET" from Job title dropdown
        Select selectSDET = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        selectSDET.selectByIndex(4);
        // 13. Click to "Java" from languages
        WebElement checkBox = driver.findElement(By.xpath("//input[@value='java']"));
        checkBox.click();
        // 14. Click to "Sign up" button
        WebElement signupButton = driver.findElement(By.id("wooden_spoon"));
        signupButton.click();
        // 15. Verify text displayed on page
        //     Expected: "Well done!"
        WebElement displayedOnPage = driver.findElement(By.tagName("h4"));
        String actualText = displayedOnPage.getText();
        String expectingText = "Well done!";
        Assert.assertEquals(actualText,expectingText);

        Driver.closeDriver();

    }
}
