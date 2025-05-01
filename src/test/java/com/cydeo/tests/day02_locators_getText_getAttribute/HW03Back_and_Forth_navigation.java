package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW03Back_and_Forth_navigation {
    public static void main(String[] args) {
//        1- Open a chrome browser
        WebDriver driver = new ChromeDriver();
//        2- Go to: https://google.com
        driver.get("https://google.com");
//        3- Click to Gmail from top right.
        WebElement gmailLink = driver.findElement(By.className("gb_X"));
        gmailLink.click();
//        4- Verify title contains:
//        Expected: Gmail
        String actualTitle = driver.getTitle();
        String expextedTitle = "Gmail";
        if(actualTitle.contains(expextedTitle)) {
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
    }
}
