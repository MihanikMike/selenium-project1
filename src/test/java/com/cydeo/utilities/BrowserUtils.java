package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {
//    This class will be storing only the utility methods that can be used across the project.
/*
    This method will accept int (in seconds) 10 and execute
    Thead.sleep method for given duration
    */
    public static void sleep(int second){
        second *= 1000;

        try{
            Thread.sleep(second);
        }catch (InterruptedException e){
        }
    }

    public static void switchWindowAndVerify(WebDriver driver,
                                             String expectedInURL,
                                             String expectedInTitle){

        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {
            driver.switchTo().window(each);
            System.out.println("Current URL: " + driver.getCurrentUrl());

            if(driver.getCurrentUrl().contains(expectedInURL)) {
                break;
            }
        }
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    public static void verifyTitle(WebDriver driver, String expectedTitle){

        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
    public static void verifyTitle2(WebDriver driver, String expectedTitle){

        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

    }


}
