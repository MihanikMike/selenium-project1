package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW02Zero_Bank_Header_Verification {
    public static void main(String[] args) {
//        1. Open Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
//        3. Verify header text
        WebElement header = driver.findElement(By.tagName("h3"));
        String expectedHeaderText = "Log in to ZeroBank";
        String actualHeaderText = header.getText();
//        Expected: “Log in to ZeroBank”
        if(actualHeaderText.equals(expectedHeaderText)) {
            System.out.println("Header verification PASSED!");
        }else{
            System.out.println("Header verification FAILED!");
        }
        driver.quit();

    }
}
