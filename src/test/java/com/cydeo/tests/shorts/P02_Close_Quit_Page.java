package com.cydeo.tests.shorts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P02_Close_Quit_Page {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.cydeo.com/open_new_tab");

        Thread.sleep(5000);

        // it will close currently open page
        //driver.close();

        // it will close all the opened browsers
        driver.quit();



    }
}
