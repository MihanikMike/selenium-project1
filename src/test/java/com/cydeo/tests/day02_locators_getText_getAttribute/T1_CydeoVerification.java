package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #1: Cydeo practice tool verifications
1. Open Chrome browser
2. Go to https://practice.cydeo.com
3. Verify URL contains
Expected: cydeo
4. Verify title:
 Expected: Practice
 */
public class T1_CydeoVerification {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.cydeo.com");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        String expectedInUrl = "cydeo";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedInUrl)) {
            System.out.println("URL verification PASSEE! " + driver.getCurrentUrl());
        }else{
            System.out.println("URL verification FAILED!");
        }
        Thread.sleep(3000);

        String expectedInTitle = "Practice";
        String actualTitle = driver.getTitle();
        if(driver.getTitle().contains("Practice")) {
            System.out.println("Title: " + driver.getTitle());
        }else{
            System.out.println("Title verification FAILED!");
        }
        driver.quit();

    }
}
