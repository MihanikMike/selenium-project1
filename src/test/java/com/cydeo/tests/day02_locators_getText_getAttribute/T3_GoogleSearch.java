package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
//        1- Open a chrome browser
        WebDriver driver = new ChromeDriver();
//        2- Go to: https://google.com
        driver.get("https://google.com");
//        3- Write “apple” in search box
        // locate search box
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        //enter "apple" key, and press Enter
        googleSearchBox.sendKeys("apple");
//        4- Press ENTER to search
        Thread.sleep(3000);
        googleSearchBox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.navigate().refresh();
        //googleSearchBox.submit();
//        5- Verify title:
        String actualTitle = driver.getTitle();
        String expectedInBeginningTitle = "apple";
//        Expected: Title should start with “apple” word
        if(actualTitle.startsWith(expectedInBeginningTitle)) {
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }
        //driver.quit();
    }
}
