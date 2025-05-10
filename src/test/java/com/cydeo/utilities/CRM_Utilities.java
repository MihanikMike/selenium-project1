package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    public static void login_crm_beta(WebDriver driver){
        /*
        This method will log in using below credentials.
        @Username: helpdesk1@cydeo.com
        @Password: UserUser
        */
        WebElement login = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        login.sendKeys("helpdesk1@cydeo.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
    }

    public static void login_crm(WebDriver driver, String username, String password){

        WebElement userLogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userLogin.sendKeys(username);

        WebElement userPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        userPassword.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
    }

}
