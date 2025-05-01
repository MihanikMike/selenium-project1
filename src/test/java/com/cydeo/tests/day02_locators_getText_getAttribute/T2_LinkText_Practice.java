package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkText_Practice {
    public static void main(String[] args) throws InterruptedException {

        //        TC #2: Back and forth navigation
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
//        1- Open a chrome browser

//        2- Go to: https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");
        Thread.sleep(2000);
//        3- Click to A/B Testing from top of the list.
        //driver.findElement(By.linkText("A/B Testing")).click();
        WebElement abTestLink = driver.findElement(By.linkText("A/B Testing"));
        abTestLink.click();
//        4- Verify title is:
//        Expected: No A/B Test
        Thread.sleep(2000);
        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");
        }
//        5- Go back to home page by using the .back();
        driver.navigate().back();
//        6- Verify title equals:
//        Expected: Practice
        String expectedTitle2 = "Practice";
        String actualTitle2 = driver.getTitle();
        if(actualTitle2.equals(expectedTitle2)) {
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }
        driver.quit();

    }
}
