package com.cydeo.tests.shorts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P01_Basicnavigations {
    public static void main(String[] args) {

        // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com");

        driver.navigate().to("https://www.amazon.com");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

    }
}
