package org.raul.lesson_5.lssn4_refactor.andersenlabpage;

import org.openqa.selenium.WebDriver;
import org.raul.lesson_4.pageobjs.tests.VerivoxPage;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * 1. Напишите 2 тест кейса на проверку каких либо визуальных элементов сайта
 * https://andersenlab.com/. (Например отображение кнопок Skype, WatsApp или
 * на переход на страницу проекта Verivox. А лучше придумайте что-нибудь свое)).
 * */
public class VerivoxPageTest {
    private WebDriver driver;
    private VerivoxPage verivoxPage;


    @BeforeMethod
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
        verivoxPage = new VerivoxPage(driver);

        driver.get("https://andersenlab.com/");
    }


    @Test
    public void verifyClickAndPageLoad() {
        String headerText = verivoxPage.navigateToVerivox().getText();
        String expectedHeaderContains = "FinTech Portal";

        Assert.assertTrue(headerText.contains(expectedHeaderContains), "Page didn't load successfully!");
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
