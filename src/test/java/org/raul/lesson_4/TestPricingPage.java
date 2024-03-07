package org.raul.lesson_4;

import org.openqa.selenium.WebDriver;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestPricingPage {
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
