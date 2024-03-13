package org.raul.lesson_5.lssn4_refactor.pagehandler;

import org.openqa.selenium.WebDriver;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.PageOperations;
import org.raul.utils.DriverSetUp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/*
 * 2. Необходимо автоматизировать сценарий, который показан на видео "Сценарий
 * для автоматизации Лекция 12.mp4".
 * */
public class PageOperationsTest {
    private static final String BASE_URL = "https://www.google.com/search";
    private static final String URL_1 = "https://www.guinnessworldrecords.com/account/register?";
    private static final String URL_2 = "https://www.hyrtutorials.com/p/alertsdemo.html";
    private static final String URL_3 = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit";

    private WebDriver driver;
    private PageOperations pageOpt;


    @BeforeSuite
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
        pageOpt = new PageOperations(driver);
    }

    @Test
    public void verifySuccessfulOpeningOfUrls() {
        driver.get(BASE_URL);
        pageOpt.searchGuinnessByUrl(URL_1);
        pageOpt.searchHyrByUrl(URL_2);
        pageOpt.searchW3ByUrl(URL_3);
    }

    @Test(dependsOnMethods = "verifySuccessfulOpeningOfUrls")
    public void executeW3SchoolsTest() {
        W3FormFillerTest w3Test = new W3FormFillerTest();
        w3Test.setUp(driver);
        w3Test.verifyRegistrationSuccessNote();
    }

    @Test(dependsOnMethods = "executeW3SchoolsTest")
    public void executeGuinnessTest() {
        GuinnessFormFillerTest guinnessTest = new GuinnessFormFillerTest();
        guinnessTest.setUp(driver);
        guinnessTest.verifyPasswordMismatchError();
    }

    @Test(dependsOnMethods = "executeGuinnessTest")
    public void executeHyrAlertsTest() {
        HyrAlertsTest hyrTest = new HyrAlertsTest();
        hyrTest.setUp(driver);
        hyrTest.verifyAlertButtonsStatusMessages();
    }



/*    private void w3FormFiller() {
//        String noteToConsole = w3Form.fillInForm("Raul", "Gurbanli");
//        System.out.println(noteToConsole);
//        Assert.assertTrue(noteToConsole.contains("Note: This tutorial will not teach you"),
//                "W3 form: 'Note' Text content didn't match!");
    }*/

/*    private void guinnessFormFiller() {
        String errorToConsole = guinnessForm.retrieveErrorMessage();
        System.out.println(errorToConsole);

        String expectedErrorText = "'Confirm password' and 'Password' do not match.";
        Assert.assertEquals(errorToConsole, expectedErrorText, "Guinness form: Couldn't get error message!");
    }*/

/*    private void hyrAlertHandler() {
        String outputTexts = hyrAlert.clickAlertBtn();
        System.out.println(outputTexts);
        Assert.assertTrue(outputTexts.contains("alert popup"), "HYR Alerts: Alert btn text didn't match!");
        Assert.assertTrue(outputTexts.contains("pressed Cancel"), "HYR Alerts: Confirm btn text didn't match!");
        Assert.assertTrue(outputTexts.contains("Final step of this task"), "HYR Alerts: Prompt btn text didn't match!");
    }*/

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
