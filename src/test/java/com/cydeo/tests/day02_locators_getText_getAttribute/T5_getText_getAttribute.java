package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getText_getAttribute {
    public static void main(String[] args) {

//        1- Open a chrome browser
        WebDriver driver = new ChromeDriver();
       // driver.manage().window().maximize();
//        2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");
//        3- Verify header text is as expected:
        WebElement header = driver.findElement(By.tagName("h2"));
//        Expected: Registration form
        String expectedHeaderText = "Registration form";
        String actualHeaderText = header.getText();
        //String actualHeaderText = header.getAttribute("innerHTML");
        if(actualHeaderText.equals(expectedHeaderText)) {
            System.out.println("Header verification PASSED!");
        }else{
            System.out.println("Header verification FAILED!");
        }
//        4- Locate “First name” input box
        WebElement firstNameInputBox = driver.findElement(By.className("form-control"));
//        5- Verify placeholder attribute’s value is as expected:
        String expectedPlaceholder = "first name";
        String actualPlaceholder = firstNameInputBox.getAttribute("placeholder");
        if(actualPlaceholder.equals(expectedPlaceholder)) {
            System.out.println("Placeholder verification PASSED!");
        }else{
            System.out.println("Placeholder verification FAILED!");
        }
//        Expected: first name
        driver.quit();
    }
}
