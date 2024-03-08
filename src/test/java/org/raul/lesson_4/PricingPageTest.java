package org.raul.lesson_4;

import org.openqa.selenium.WebDriver;
import org.raul.lesson_4.pageobjs.tests.PricingPage;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * 1. Напишите 2 тест кейса на проверку каких либо визуальных элементов сайта
 * https://andersenlab.com/. (Например отображение кнопок Skype, WatsApp или
 * на переход на страницу проекта Verivox. А лучше придумайте что-нибудь свое)).
 * */
public class PricingPageTest {
    private WebDriver driver;
    private PricingPage pricingPage;


    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
        pricingPage = new PricingPage(driver);

        driver.get("https://andersenlab.com/");
    }


    @Test
    public void verifyUrlAfterClickGetPricingButton() {
        pricingPage.clickPricingButton();

        Assert.assertTrue(pricingPage.isCostEstimationPageUrl(), "URL mismatch!");
    }


    @Test
    public void verifyGetPricingButtonLoadsEstimationPage() {
        pricingPage.clickPricingButton();

        String expectedHeader = "Request an IT project cost estimate";
        Assert.assertEquals(pricingPage.checkCostEstimationPageHeader(), expectedHeader, "Header mismatch!");
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
