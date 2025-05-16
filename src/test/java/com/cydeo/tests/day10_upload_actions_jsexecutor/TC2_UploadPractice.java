package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.opentelemetry.sdk.metrics.internal.concurrent.AdderUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2_UploadPractice {

    @Test
    public void test1() {
//        TC #2 Upload Test
//        1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");
//        2. Find some small file from your computer, and get the path of it.
        String path = "C:\\Users\\mrter\\OneDrive\\Desktop\\file_for_selenium";
//        3. Upload the file.
        WebElement chooseFile = Driver.getDriver().findElement(By.id("file-upload"));
        BrowserUtils.sleep(2);
        chooseFile.sendKeys(path);
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();
//        4. Assert:
//        -File uploaded text is displayed on the page
        WebElement fileUploadedHeader = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedHeader.isDisplayed(), "Header text is NOT displayed");
    }
}
