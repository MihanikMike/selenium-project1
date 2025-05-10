package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class TC3_Utility_method_task {
    public static void main(String[] args) throws InterruptedException {

//        TC #2: Radiobutton handling
//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");
        clickAndVerifyRadioButton(driver, "sport", "football");
        clickAndVerifyRadioButton(driver, "color", "red");

//        3. Click to “Hockey” radio button
        WebElement hockeyRadioBtn = driver.findElement(By.xpath("//input[@id='hockey']"));
        Thread.sleep(2000);
        hockeyRadioBtn.click();
//        4. Verify “Hockey” radio button is selected after clicking.
        if (hockeyRadioBtn.isSelected()) {
            System.out.println("Button is selected. Verification is passed!");
        } else {
            System.out.println("Button is NOT selected. Verification is failed!");
        }
//        USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
        /*   List<WebElement> sportRadioBtn = driver.findElements(By.xpath("//input[@name='sport']"));
        for (WebElement each : sportRadioBtn) {
            String actualID = each.getDomAttribute("id");
            if (actualID.equals("hockey")) {
                each.click();
                System.out.println(actualID + " is selected: " + each.isSelected());
            }
        }
*/

        /*
        Create a utility method to handle above logic.
Method name: clickAndVerifyRadioButton
Return type: void or boolean
Method args:
1. WebDriver
2. Name attribute as String (for providing which group of radio buttons)
3. Id attribute as String (for providing which radio button to be clicked)
Method should loop through the given group of radio buttons. When it finds the
matching option, it should click and verify option is Selected.
Print out verification: true
         */
        driver.quit();
    }

    public static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String expectedID) {

        //List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='"+nameAttribute+"']"));
        List<WebElement> radioButtons = driver.findElements(By.name(nameAttribute));

        for (WebElement each : radioButtons) {
            String actualID = each.getDomAttribute("id");

            if (actualID.equals(expectedID)) {
                each.click();
                System.out.println(actualID + " is selected: " + each.isSelected());
                break;
            }
        }
    }
}


