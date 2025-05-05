package com.cydeo.tests.review.week2;

import com.cydeo.utillities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC01Practice_page_Login_Test {
    public static void main(String[] args) {

// TC#1: Practice page Login test

        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // 2. Go to https://practice.cydeo.com/login
        driver.get("https://practice.cydeo.com/login");
        // 3. Enter username: "tomsmith"
        WebElement loginLine = driver.findElement(By.cssSelector("input[name='username']"));
        loginLine.sendKeys("tomsmith");
        // 4. Enter password: "SuperSecretPassword"
        WebElement loginPassword = driver.findElement(By.cssSelector("input[name='password']"));
        loginPassword.sendKeys("SuperSecretPassword");
        // 5. Click to Login button
        WebElement loginButton = driver.findElement(By.cssSelector("button#wooden_spoon"));
        loginButton.click();
        // 6. Verify text displayed on page contains
        // 7. Expected: "You logged into a secure area!"
        String expectedText = "You logged into a secure area!";
        WebElement containsOnPage = driver.findElement(By.xpath("//div[@id='flash']"));

        String actualText = containsOnPage.getText();
        System.out.println(expectedText);
        System.out.println(actualText);
        if (actualText.equals(expectedText)) {
            System.out.println("Verification passed!");
        } else {
            System.out.println("Verification failed!");
        }
        //driver.quit();
    }
}
