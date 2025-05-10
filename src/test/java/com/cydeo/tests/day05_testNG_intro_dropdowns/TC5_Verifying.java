package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC5_Verifying {

    WebDriver driver;

    @BeforeMethod
        public void setupMethod() {
        //    TC#5: Verifying “Simple dropdown” and “State selection” dropdown
//    default values
//    1. Open Chrome browser
//    2. Go to https://practice.cydeo.com/dropdown
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://practice.cydeo.com/dropdown");
        }
    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

    @Test
    public void simple_dropdowns_test() {
//    3. Verify “Simple dropdown” default selected value is correct
//    Expected: “Please select an option”
        //Locating the dropdown as a web element
        WebElement simpleDropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        //Creating Select class objact, and passing the dropdown web element into the constructor
        Select select = new Select(simpleDropdown);
        String expectedDefaultValue = "Please select an option";
        //Actual:
        String actualDefaltValue = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDefaltValue, expectedDefaultValue);

//    4. Verify “State selection” default selected value is correct

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String expectedDefaltStateValue =  "Select a State";
        String actualDefaltStateValue = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualDefaltStateValue, expectedDefaltStateValue);

    }
//    Expected: “Select a State"
//

}
