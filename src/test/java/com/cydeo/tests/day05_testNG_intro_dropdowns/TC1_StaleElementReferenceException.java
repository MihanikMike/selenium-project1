package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class TC1_StaleElementReferenceException {
    public static void main(String[] args) throws InterruptedException {

//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

//        3. Click to “Add Element” button
        WebElement addButtonElement = driver.findElement(By.xpath("//button[.='Add Element']"));
        addButtonElement.click();
//        4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButtonElement = driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("deleteButtonElement.isDisplayed(), expecting true = " + deleteButtonElement.isDisplayed());
        Thread.sleep(2000);
//        5. Click to “Delete” button.
        deleteButtonElement.click();
//        6. Verify “Delete” button is NOT displayed after clicking.

        //use try/catch to handle and verify
        try{
            System.out.println("deleteButtonElement.isDisplayed(), expecting false = " + deleteButtonElement.isDisplayed());
        }catch (StaleElementReferenceException e) {
            System.out.println("-->StaleElementException happened due to element being deleted from the page.");
            System.out.println("Which concludes our test case -PASSING!-");
            System.out.println("deleteButtonElement.isDisplayed() = false");
        }

//        USE XPATH LOCATOR FOR ALL WebElement LOCATORS
        driver.quit();
    }
}
