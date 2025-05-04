package com.cydeo.tests.review.week2;

import com.cydeo.utillities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TC03 {
    public static void main(String[] args) throws InterruptedException {

        // TC#3: Radio button test

        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // 2. https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");
        // 3. Verify you are on the correct page
        if(driver.getTitle().contains("Radio")){
            System.out.println("you are on the correct page");
        }
        // 4. Locate all favorite sports
        List<WebElement> allList = driver.findElements(By.cssSelector("input[name='sport']"));
        // 5. Click one by one nad verify it is clicked
        for (WebElement each : allList) {
            each.click();
            Thread.sleep(3000);
            if(each.isSelected()){
                System.out.println("Clicked " + each.getDomAttribute("id"));
            }
        }
        driver.close();


    }
}
