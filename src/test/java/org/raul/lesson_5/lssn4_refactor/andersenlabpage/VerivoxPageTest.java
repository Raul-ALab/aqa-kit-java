package org.raul.lesson_5.lssn4_refactor.andersenlabpage;

import org.openqa.selenium.WebDriver;
import org.raul.lesson_5.refactoring_lssn4.andersenlabpage.VerivoxPage;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * Refactoring:
 * 1. Напишите 2 тест кейса на проверку каких либо визуальных элементов сайта
 * https://andersenlab.com/. (Например отображение кнопок Skype, WatsApp или
 * на переход на страницу проекта Verivox. А лучше придумайте что-нибудь свое)).
 *
 * L02: testcases_ lssn12.xlsx
 * */
public class VerivoxPageTest {
    private WebDriver driver;
    private VerivoxPage verivoxPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
        verivoxPage = new VerivoxPage(driver);

        driver.get("https://andersenlab.com/");
        verivoxPage.acceptCookies();
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
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}
