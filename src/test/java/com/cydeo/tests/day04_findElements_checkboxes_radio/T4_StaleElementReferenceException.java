package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utillities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T4_StaleElementReferenceException {
    public static void main(String[] args) throws InterruptedException {

//        1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");
//        3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println("Before refresh: expected true = " + cydeoLink.isDisplayed());
        Thread.sleep(3000);
//        4- Refresh the page.
        driver.navigate().refresh();
        System.out.println("Refreshing the page... ");
//        5- Verify it is displayed, again.
        cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println("After refresh: expected true = " + cydeoLink.isDisplayed());
//                This is a simple StaleElementReferenceException to understand what is
//        this exception and how to handle it.
        driver.quit();

    }
}
