package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Driver {

    private Driver() {}
    /*
We make the WebDriver private, because we want to close access from outside the class.
We are making it static, because we will use it in a static method.
     */
    private static WebDriver driver; //default value = null

    /*
    Create a re-usable utility method which will return the same driver instance once we call it.
- If an instance doesn't exist, it will create first, and then it will always return same instance.
     */

    public static WebDriver getDriver() {

        if (driver == null) {

            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType) {
                case "chrome":
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
                    break;

            }
        }
        return driver;
    }

    public static void closeDriver() {
        if(driver!=null) {
            driver.quit();
            driver = null;
        }
    }
}
