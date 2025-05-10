package com.cydeo.tests.review.week2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC02CheckBoxTest {
    public static void main(String[] args) {

        // TC#2: Checkbox test

        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // 2. Go to https://practice.cydeo.com/checkboxes
        driver.get("https://practice.cydeo.com/checkboxes");
        // 3. Verify you are on the correct page
        if(driver.getTitle().contains("Checkboxes")) {
            System.out.println("You on the right page");
        }
        // 4. Click Checkbox1
        WebElement checkbox1 = driver.findElement(By.id("box1"));
        checkbox1.click();
        // 5. Verify it is checked
        if(checkbox1.isSelected()) {
            System.out.println("TRUE");
        }else {
            System.out.println("FALSE");
        }
        // 6. Click Checkbox1
        checkbox1.click();
        // 7. Verify it is unchecked
        if(checkbox1.isSelected()) {
            System.out.println("TRUE");
        }else {
            System.out.println("FALSE");
        }
        driver.quit();

    }
}
