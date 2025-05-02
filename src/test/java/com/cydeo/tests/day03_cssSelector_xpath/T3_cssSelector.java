package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utillities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_cssSelector {
    public static void main(String[] args) {

//        1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
//        2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
//        3- Verify “Log in” button text is as expected:
//        Expected: Log In
        String expectedLoginText = "Log In";

        WebElement loginButtonText = driver.findElement(By.cssSelector("input[class='login-btn']"));

        String actualLogintext = loginButtonText.getAttribute("value");

        if(actualLogintext.equals(expectedLoginText)) {
            System.out.println("Login In button text verification PASSED!");
        }else{
            System.out.println("Login In button text verification FAILED!");
        }

//        PS: Inspect and decide which locator you should be using to locate web
//        elements.
//                PS2: Pay attention to where to get the text of this button from

    }
}
