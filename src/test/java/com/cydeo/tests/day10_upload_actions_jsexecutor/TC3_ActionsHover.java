package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class TC3_ActionsHover {
    @Test
    public void test1() {
        //    TC #3: Hover Test
//1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");
//2. Hover over to first image
        WebElement image1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement image2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement image3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);
        actions.moveToElement(image1).perform();
//3. Assert:
//   a. “name: user1” is displayed
        Assert.assertTrue(user1.isDisplayed());

//4. Hover over to second image
        actions.moveToElement(image2).perform();
        BrowserUtils.sleep(2);
//5. Assert:
//   a. “name: user2” is displayed
        Assert.assertTrue(user2.isDisplayed());

//6. Hover over to third image
        actions.moveToElement(image3).perform();
        BrowserUtils.sleep(2);
//7. Confirm:
//   a. “name: user3” is displayed
        Assert.assertTrue(user3.isDisplayed());

        Driver.closeDriver();

    }


}
