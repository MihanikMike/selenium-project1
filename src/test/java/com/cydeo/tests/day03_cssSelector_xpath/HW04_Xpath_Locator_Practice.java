package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW04_Xpath_Locator_Practice {
    public static void main(String[] args) {
//        1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
//        2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");
//        3- Click to “Home” link
        WebElement homeButton = driver.findElement(By.xpath("//a[@class='nav-link']"));
        homeButton.click();
//        4- Verify title is as expected:
//        Expected: Practice
//        PS: Locate “Home” link using “xpath” locator
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Title verification FAILED");
        }
        driver.quit();
    }
}
