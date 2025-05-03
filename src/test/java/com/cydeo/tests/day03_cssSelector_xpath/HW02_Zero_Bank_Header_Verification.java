package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utillities.WebDriverFactory;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW02_Zero_Bank_Header_Verification {
    public static void main(String[] args) {

//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
//        2. Go to http://zero.webappsecurity.com/login.html
        //driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");
//        3. Verify header text
//        Expected: “Log in to ZeroBank”
        WebElement header = driver.findElement(By.cssSelector("div.page-header"));

        String expectedHeader = "Log in to ZeroBank";
        String actualHeader = header.getText();

        if(actualHeader.equals(expectedHeader)) {
            System.out.println("Header verification PASSED!");
        }else{
            System.out.println("Header verification FAILED!");
        }
        driver.quit();

    }
}
