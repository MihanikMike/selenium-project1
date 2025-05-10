package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practices {
    public static void main(String[] args) throws InterruptedException {

//        TC #1: XPATH and cssSelector Practices
//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
//        2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");
//        3. Locate all the WebElements on the page using XPATH and/or CSS
//        locator only (total of 6)
//        a. “Home” link
        WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
        WebElement homeLink2 = driver.findElement(By.cssSelector("a.nav-link"));
//        b. “Forgot password” header
        WebElement forgotPasswordHead = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        WebElement forgotPasswordHead2 = driver.findElement(By.cssSelector("div[class='example']>h2"));
        WebElement forgotPasswordHead3 = driver.findElement(By.cssSelector("div.example>h2"));
//        c. “E-mail” text
        WebElement emailText = driver.findElement(By.xpath("//label[@for='email']"));
        WebElement emailText2 = driver.findElement(By.xpath("//label[.='E-mail']"));
//        d. E-mail input box
        WebElement emailInput = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement emailInput2 = driver.findElement(By.xpath("//input[contains(@pattern,'[a-z0-9._%+-]')]"));
//        e. “Retrieve password” button
        // WebElement passwordButton = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']")); <-- i just make text Italic
        WebElement passwordButton = driver.findElement(By.xpath("//button[@id='form_submit']"));
//        f. “Powered by Cydeo text
        WebElement cydeoText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed());
        System.out.println("forgotPasswordHead.isDisplayed() = " + forgotPasswordHead.isDisplayed());
        System.out.println("emailText.isDisplayed() = " + emailText.isDisplayed());
        System.out.println("emailInput.isDisplayed() = " + emailInput.isDisplayed());
        System.out.println("passwordButton.isDisplayed() = " + passwordButton.isDisplayed());
        System.out.println("cydeoText.isDisplayed() = " + cydeoText.isDisplayed());
//        4. Verify all web elements are displayed.
//        First solve the task with using cssSelector only. Try to create 2 different
//        cssSelector if possible
//        Then solve the task using XPATH only. Try to create 2 different
//        XPATH locator if possible
        Thread.sleep(2000);
        driver.quit();

    }
}
