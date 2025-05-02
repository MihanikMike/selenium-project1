package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utillities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_locators_getText {
    public static void main(String[] args) {

//        1- Open a chrome browser
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

//        2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
//        3- Enter incorrect username: “incorrect”
        WebElement inputUserName = driver.findElement(By.className("login-inp"));
        inputUserName.sendKeys("incorrect");
//        4- Enter incorrect password: “incorrect”
        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys("incorrect");
//        5- Click to login button.
        WebElement clickButton = driver.findElement(By.className("login-btn"));
        clickButton.click();
//        6- Verify error message text is as expected:
//        Expected: Incorrect login or password
        String expected = "Incorrect login or password";
        WebElement errorText = driver.findElement(By.className("errortext"));
        String actual = errorText.getText();
        if (actual.equals(expected)) {
            System.out.println("Error text verification PASSED!");
        } else {
            System.out.println("Error text verification FAILED!");
        }
        driver.close();

    }
}
