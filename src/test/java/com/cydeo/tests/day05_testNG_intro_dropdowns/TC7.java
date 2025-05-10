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

public class TC7 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
//    TC #7: Selecting state from State dropdown and verifying result
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
    public void selectingState() throws InterruptedException {
//    3. Select Illinois
        Select selectIllinois = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        selectIllinois.selectByVisibleText("Illinois");
//        String expectedIllinois = "Illinois";
//        String actualState1 = selectIllinois.getFirstSelectedOption().getText();
//        Assert.assertEquals(expectedIllinois, actualState1);
        Thread.sleep(2000);
//    4. Select Virginia
        Select selectVirginia = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        selectIllinois.selectByValue("VA");
//        String expectedVirginia = "Virginia";
//        String actualState2 = selectVirginia.getFirstSelectedOption().getText();
//        Assert.assertEquals(expectedVirginia, actualState2);
        Thread.sleep(2000);
//    5. Select California
        Select selectICalifornia = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        selectIllinois.selectByIndex(5);
        String expectedCalifornia = "California";
        String actualState3 = selectICalifornia.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedCalifornia, actualState3, "State dropdown value is not expected!");
        Thread.sleep(2000);
//    6. Verify





    }

//    final selected option is California.
//    Use all Select options. (visible text, value, index)
}
