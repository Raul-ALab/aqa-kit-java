package org.raul.lesson_5.lssn4_refactor.pagehandler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.raul.lesson_5.refactoring_lssn4.pagehandler.GuinnessFormFiller;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.HyrFormFiller;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.PageOperations;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.W3FormFiller;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

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
    private WebDriverWait wait;
    private PageOperations pageOpt;
    private W3FormFiller w3Form;
    private GuinnessFormFiller guinnessForm;
    private HyrFormFiller hyrAlert;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        pageOpt = new PageOperations(driver);
        w3Form = new W3FormFiller(driver, "Raul", "Gurbanli");
        guinnessForm = new GuinnessFormFiller(driver);
        hyrAlert = new HyrFormFiller(driver);
    }

    @Test
    public void verifyPageOperationsScenario() {
        openUrls();
        w3FormFiller();
        guinnessFormFiller();
        hyrAlertHandler();
    }

    private void openUrls() {
        driver.get(BASE_URL);
        pageOpt.searchGuinnessByUrl(URL_1);
        pageOpt.searchHyrByUrl(URL_2);
        pageOpt.searchW3ByUrl(URL_3);
    }

    private void w3FormFiller() {
//        String noteToConsole = w3Form.fillInForm("Raul", "Gurbanli");
//        System.out.println(noteToConsole);
//        Assert.assertTrue(noteToConsole.contains("Note: This tutorial will not teach you"),
//                "W3 form: 'Note' Text content didn't match!");
    }

    private void guinnessFormFiller() {
        String errorToConsole = guinnessForm.retrieveErrorMessage();
        System.out.println(errorToConsole);

        String expectedErrorText = "'Confirm password' and 'Password' do not match.";
        Assert.assertEquals(errorToConsole, expectedErrorText, "Guinness form: Couldn't get error message!");
    }

    private void hyrAlertHandler() {
        String outputTexts = hyrAlert.clickAlertBtn();
        System.out.println(outputTexts);
        Assert.assertTrue(outputTexts.contains("alert popup"), "HYR Alerts: Alert btn text didn't match!");
        Assert.assertTrue(outputTexts.contains("pressed Cancel"), "HYR Alerts: Confirm btn text didn't match!");
        Assert.assertTrue(outputTexts.contains("Final step of this task"), "HYR Alerts: Prompt btn text didn't match!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
