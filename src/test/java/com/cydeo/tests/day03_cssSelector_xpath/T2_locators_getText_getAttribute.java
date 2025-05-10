package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_locators_getText_getAttribute {
    public static void main(String[] args) {

//        1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
//        2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
//        3- Verify “remember me” label text is as expected:
//        Expected: Remember me on this computer
        String expectedText = "Remember me on this computer";
        WebElement labelText = driver.findElement(By.className("login-item-checkbox-label"));
        String acualText = labelText.getText();
        if(acualText.equals(expectedText)) {
            System.out.println("Label text verification PASSED!");
        }else{
            System.out.println("Label text verification FAILED!");
        }
//        4- Verify “forgot password” link text is as expected:
//        Expected: Forgot your password?
        String expectedPasswordLink = "FORGOT YOUR PASSWORD?";
        WebElement forgotPasswordLinkText = driver.findElement(By.className("login-link-forgot-pass"));
        String actualPasswordLink = forgotPasswordLinkText.getText();

        if(actualPasswordLink.equals(expectedPasswordLink)) {

            System.out.println("Link text verification PASSED!");
        }else{
            System.out.println("Link text verification FAILED!");
        }
//                5- Verify “forgot password” href attribute’s value contains expected:
//        Expected: forgot_password=yes
//        PS: Inspect and decide which locator you should be using to locate web
//        elements.

        String expectedInHref = "forgot_password=yes";
        String actualInHref = forgotPasswordLinkText.getAttribute("href");

        if(actualInHref.contains(expectedInHref)) {
            System.out.println("HREF attribute value is as EXPECTED. PASS");
        }else{
            System.out.println("HREF attribute value is NOT as EXPECTED. PASS");
        }

    }
}
