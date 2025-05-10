package com.cydeo.tests.day7_webtables_utillities_javafacer;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_CRM_Login_Task {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @Test
    public void test_crm_login() {
        /*
        driver.get("https://login1.nextbasecrm.com/");
        WebElement login = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        login.sendKeys("helpdesk1@cydeo.com");
//        USERNAME
//        helpdesk1@cydeo.com
        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        BrowserUtils.sleep(3);
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "Portal");
        */

    }

    @Test
    public void test_crm_login2() {
        driver.get("https://login1.nextbasecrm.com/");

        //CRM_Utilities.login_crm_beta(driver);
        CRM_Utilities.login_crm(driver, "helpdesk2@cydeo.com", "UserUser");

        BrowserUtils.sleep(3);
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "Portal");

    }
}
