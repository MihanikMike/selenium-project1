package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW03_Back_and_Forth_Navigation {
    public static void main(String[] args) {

//        1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
//        2- Go to: https://google.com
        driver.get("https://google.com");

//        3- Click to Gmail from top right.
        WebElement gmailButton = driver.findElement(By.cssSelector("a[aria-label='Gmail ']"));
        gmailButton.click();

//        4- Verify title contains:
//        Expected: Gmail
        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(expectedTitle)) {
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }
//        5- Go back to Google by using the .back();
        driver.navigate().back();
//        6- Verify title equals:
//        Expected: Google
        String expectedTitle2 = "Google";
        String actualTitle2 = driver.getTitle();
        if(actualTitle2.equals(expectedTitle2)) {
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }
        driver.quit();
    }
}
