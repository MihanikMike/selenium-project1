package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePageUtilities {

    private WebElement getWebelement(String text, WebDriver driver){
        String locator = "//a[.='"+text+"']";
        return driver.findElement(By.xpath(locator));
    }
}
