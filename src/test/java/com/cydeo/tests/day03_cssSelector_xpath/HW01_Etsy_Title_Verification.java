package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW01_Etsy_Title_Verification {
    public static void main(String[] args) throws InterruptedException {
//        HWP #1: Etsy Title Verification
//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
//        2. Go to https://www.etsy.com
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
        driver.navigate().refresh();
//        3. Search for “wooden spoon”
        WebElement searchLine = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        Thread.sleep(3000);
        searchLine.sendKeys("wooden spoon");
        Thread.sleep(3000);
        searchLine.sendKeys(Keys.ENTER);
        driver.navigate().refresh();

//        4. Verify title:
//        Expected: “Wooden spoon - Etsy”
        String expectedTitle = "Amazon.com : wooden spoon";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        if(actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }
        driver.quit();
    }
}
