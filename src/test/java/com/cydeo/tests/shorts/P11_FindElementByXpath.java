package com.cydeo.tests.shorts;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P11_FindElementByXpath {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/forgot_password");
        WebElement emailBox = driver.findElement(By.xpath("//input[@type='text']"));
        emailBox.sendKeys("abc@email.com");
        WebElement passwordButton = driver.findElement(By.cssSelector("button#form_submit"));
        passwordButton.click();
        WebElement text = driver.findElement(By.xpath("h4"));

        if (text.equals("Your email's been sent!")) {
            System.out.println("Text verification is passed!");
        }else{
            System.out.println("Text verification is failed!");
        }

    }
}
