package org.raul.lesson_6.lssn4_refactor.andersenlabpage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.raul.lesson_6.refactoring_lssn4.andersenlabpage.VerivoxPage;
import org.raul.listener.AllureTestListener;
import org.raul.utils.DriverSetUp2;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
 * L02: testcases_ lssn12.xlsx
 * */
@Listeners({AllureTestListener.class})
@Epic("AndersenLab Website Testing")
@Feature("Verivox project page")
@Owner("Rashad Raul")
public class VerivoxPageTest {
    private static final String URL = "https://andersenlab.com/";

    private WebDriver driver;
    private VerivoxPage verivoxPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverSetUp2.startDriver();
        verivoxPage = new VerivoxPage(driver);

        driver.get(URL);
        verivoxPage.acceptCookies();
    }

    @Test
    @Description("Test Case L02 : Switch to Verivox page.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Verify if clicking on the Verivox menu switches to and loads the correct page")
    @Link(name = "Test Cases file lesson.12", url = "src/test/resources/testcases_ lssn12.xlsx")
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
