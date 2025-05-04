package com.cydeo.tests.day02_locators_getText_getAttribute;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW01Etsy_Title_Verification {
    public static void main(String[] args) {
//        HWP #1: Etsy Title Verification
//        1. Open Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");
        driver.navigate().refresh();
//        3. Search for “wooden spoon”
        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys("wooden spoon");
        searchBox.sendKeys(Keys.ENTER);
//        4. Verify title:
        String actualTitle = driver.getTitle();
        String expectedTitle = "Wooden spoon - Etsy";
//        Expected: “Wooden spoon - Etsy”
        if(actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }
        driver.quit();
    }
}
