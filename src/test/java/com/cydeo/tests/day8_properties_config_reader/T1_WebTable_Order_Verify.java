package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_WebTable_Order_Verify {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void order_verify_name_test() {
//        1. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");
//        2. Verify Bob’s name is listed as expected.
        WebElement bobsCell = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        System.out.println("bobsCell.getText = " + bobsCell.getText());
//        Expected: “Bob Martin”
        String bobsName = "Bob Martin";
        String actualName = bobsCell.getText();
        Assert.assertEquals(actualName, bobsName, "Name are not matching!");
//        3. Verify Bob Martin’s order date is as expected
//        Expected: 12/31/2021
        WebElement bobsOrderDate =
                driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']//following-sibling::td[3]"));
        String expectingOrderDate = "12/31/2021";
        String actualOrderDate = bobsOrderDate.getText();
        Assert.assertEquals(actualOrderDate, expectingOrderDate, "Order date NOT correct");
    }

    @Test
    public void test2() {
        driver.get("https://practice.cydeo.com/web-tables");
        String stewartDawidson = WebOrderUtils.returnOrderDate(driver, "Stewart Dawidson");
        System.out.println("stewartDawidson = " + stewartDawidson);
    }

    @Test
    public void test3() {
        driver.get("https://practice.cydeo.com/web-tables");
        WebOrderUtils.orderVerify(driver, "Stewart Dawidson", "03/29/2021");

    }
}
