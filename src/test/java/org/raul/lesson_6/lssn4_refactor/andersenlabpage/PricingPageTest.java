package org.raul.lesson_6.lssn4_refactor.andersenlabpage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.raul.lesson_6.refactoring_lssn4.andersenlabpage.PricingPage;
import org.raul.listener.AllureTestListener;
import org.raul.utils.DriverSetUp2;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
 * 1.	Добавьте аллюр-репортинг к нашим тестам: своему проекту.
 * 2.	Добавьте браузерные логи, если это потребуется.
 *
 * 1. Напишите 2 тест кейса на проверку каких либо визуальных элементов сайта
 * https://andersenlab.com/. (Например отображение кнопок Skype, WatsApp или
 * на переход на страницу проекта Verivox. А лучше придумайте что-нибудь свое)).
 *
 * L01: testcases_ lssn12.xlsx
 * */
@Listeners({AllureTestListener.class})
@Epic("AndersenLab Website Testing")
@Feature("Get pricing page")
public class PricingPageTest {
    private static final String URL = "https://andersenlab.com/";

    private WebDriver driver;
    private PricingPage pricingPage;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp2.startDriver();
        pricingPage = new PricingPage(driver);

        driver.get(URL);
        pricingPage.acceptCookies();
    }

    @Test
    @Description("Test Case L01 : Switch to Cost Estimation page.")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Check if clicking the Get Pricing button leads to the cost estimation page.")
    @Link(name = "Test Cases file lesson.12", url = "src/test/resources/testcases_ lssn12.xlsx")
    public void verifyUrlAfterClickGetPricingButton() {
        pricingPage.clickPricingButton();

        Assert.assertTrue(pricingPage.isCostEstimationPageUrl(), "URL mismatch!");
    }

    @Test
    @Description("Test Case L01 : Ensure that the correct page loads after clicking the Get Pricing button.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Check if the loaded page contains correct content")
    @Link(name = "Test Cases file lesson.12", url = "src/test/resources/testcases_ lssn12.xlsx")
    public void verifyGetPricingButtonLoadsEstimationPage() {
        pricingPage.clickPricingButton();

        String expectedHeader = "Request an IT project cost estimate";
        Assert.assertEquals(pricingPage.checkCostEstimationPageHeader(), expectedHeader, "Header mismatch!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}
