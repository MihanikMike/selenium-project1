package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_Library_Practice {
    public static void main(String[] args) {
//        1. Open Chrome browser
        WebDriver driver = new ChromeDriver();
//        2. Go to http://library2.cybertekschool.com/login.html
        driver.get("https://library2.cybertekschool.com/login.html");
//        3. Enter username: “incorrect@email.com”
        WebElement usernameInputBox = driver.findElement(By.className("form-control"));
        usernameInputBox.sendKeys("incorrect@email.com");
//        PS: Locate username input box using “className” locator
//        4. Enter password: “incorrect password”
//        Locate password input box using “id” locator
        WebElement passwordInputBox = driver.findElement(By.id("inputPassword"));
        passwordInputBox.sendKeys("anything");
//        5. Verify: visually “Sorry, Wrong Email or Password”
//        displayed
        WebElement signInButton = driver.findElement(By.tagName("button"));
        signInButton.click();
//        Locate Sign in button using “tagName” locator
    }
}
