package org.raul.lesson_6.lssn4_refactor.pagehandler;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Epics;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.raul.lesson_6.refactoring_lssn4.pagehandler.PageOperations;
import org.raul.listener.AllureTestListener;
import org.raul.utils.DriverSetUp2;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
 * 1.	Добавьте аллюр-репортинг к нашим тестам: своему проекту.
 * 2.	Добавьте браузерные логи, если это потребуется.
 *
 * This method is to execute all tests for scenario 2 : W3Schools, Guinness, and HyrAlerts.
 * 2. Необходимо автоматизировать сценарий, который показан на видео "Сценарий
 * для автоматизации Лекция 12.mp4".
 * */
@Listeners({AllureTestListener.class})
@Epics({
        @Epic("W3School Page"),
        @Epic("Guinness Page"),
        @Epic("HYR Alerts")
})
@Feature("Page Interactions Tests Runner")
@Owner("Rashad Raul")
public class PageOperationsTestManager {
    private static final String BASE_URL = "https://www.google.com/search";
    private static final String URL_1 = "https://www.guinnessworldrecords.com/account/register?";
    private static final String URL_2 = "https://www.hyrtutorials.com/p/alertsdemo.html";
    private static final String URL_3 = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit";

    private WebDriver driver;
    private PageOperations pageOpt;


    @BeforeSuite
    public void setUp() {
        driver = DriverSetUp2.startDriver();
        pageOpt = new PageOperations(driver);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Description("Opening and navigating to URLs on new tabs.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Main Test Runner of PageOperations class")
    public void verifySuccessfulOpeningOfUrls() {
        driver.get(BASE_URL);
        pageOpt.searchGuinnessByUrl(URL_1);
        pageOpt.searchHyrByUrl(URL_2);
        pageOpt.searchW3ByUrl(URL_3);
    }

    @Test(dependsOnMethods = "verifySuccessfulOpeningOfUrls")
    @Description("Execute and manage tests from W3FormFillerTest.")
    public void executeW3SchoolsTest() {
        W3FormFillerTest w3Test = new W3FormFillerTest();
        w3Test.setUp(driver);
        w3Test.verifyRegistrationSuccessNote();
    }

    @Test(dependsOnMethods = "executeW3SchoolsTest", alwaysRun = true)
    @Description("Execute and manage tests from GuinnessFormFillerTest.")
    public void executeGuinnessTest() {
        GuinnessFormFillerTest guinnessTest = new GuinnessFormFillerTest();
        guinnessTest.setUp(driver);
        guinnessTest.verifyPasswordMismatchErrors();
    }

    @Test(dependsOnMethods = "executeGuinnessTest", alwaysRun = true)
    @Description("Execute and manage tests from HyrAlertsTest.")
    public void executeHyrAlertsTest() {
        HyrAlertsTest hyrTest = new HyrAlertsTest();
        hyrTest.setUp(driver);
        hyrTest.verifyAlertButtonsStatusMessages();
    }
}
