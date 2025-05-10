package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC6 {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod() {
        //    TC #6: Selecting date on dropdown and verifying
        //    1. Open Chrome browser
        //    2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @Test
    public void selectingDataOnDropDown() {
//    3. Select “December 1st, 1933” and verify it is selected.
//    Select year using : visible text
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        yearDropdown.selectByVisibleText("1933");

//    Select month using : value attribute
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthDropdown.selectByValue("11");

//    Select day using : index number
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dayDropdown.selectByIndex(0);

        String expectingYear = "1933";
        String expectedMonth = "December";
        String expectedDay = "1";

        String selectedYear = yearDropdown.getFirstSelectedOption().getText();
        String selectedMonth = monthDropdown.getFirstSelectedOption().getText();
        String selectedDay = dayDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(selectedYear, expectingYear, "Year selection failed!");
        Assert.assertEquals(selectedMonth, expectedMonth, "Month selection failed!");
        Assert.assertEquals(selectedDay, expectedDay,"Day selection failed!");
    }
}
