package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_Registration {

    @Test
    public void test1() {
        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));
        // 3. Enter First name: "John"
        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Mike");
        // 4. Enter Last name: "Smith"
        WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Smith");
        // 5. Enter Username: "johnsmith123"
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("johnsmith123");
        // 6. Enter Email address: "john.smith@email.com"
        WebElement emailAddress = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        emailAddress.sendKeys("john.smith@email.com");
        // 7. Enter password: "John1234"
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("John1234");
        // 8. Enter Phone number: "123-456-7890"
        WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys("123-456-7890");
        // 9. Click to "Male" from Gender
        WebElement radioButton = Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        radioButton.click();
        // 10. Enter Date of birth "01/28/1990"
        WebElement birthDate = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        birthDate.sendKeys("01/28/1990");
        // 11. Select "Department of Engineering" from Department/Office dropdown
        Select selectDoE = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        selectDoE.selectByIndex(1);
        // 12. Select "SDET" from Job title dropdown
        Select selectSDET = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        selectSDET.selectByIndex(4);
        // 13. Click to "Java" from languages
        WebElement checkBox = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        checkBox.click();
        // 14. Click to "Sign up" button
        WebElement signupButton = Driver.getDriver().findElement(By.id("wooden_spoon"));
        signupButton.click();
        // 15. Verify text displayed on page
        //     Expected: "Well done!"
        WebElement displayedOnPage = Driver.getDriver().findElement(By.tagName("h4"));
//
        Assert.assertTrue(displayedOnPage.isDisplayed());
//        String actualText = displayedOnPage.getText();
//        String expectingText = "Well done!";
//        Assert.assertEquals(actualText,expectingText);





    }
}
