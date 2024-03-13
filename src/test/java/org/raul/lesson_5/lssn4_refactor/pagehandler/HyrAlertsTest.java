package org.raul.lesson_5.lssn4_refactor.pagehandler;

import org.openqa.selenium.WebDriver;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.HyrFormFiller;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HyrFormFillerTest {
    private HyrFormFiller hyrForm;


    @BeforeClass
    public void setUp(WebDriver driver) {
        hyrForm = new HyrFormFiller(driver);
        hyrForm.switchToAlertsPage();
    }

    @Test
    public void verifyAlertButtonsStatusMessages() {
        String alertBtnStatusNote = hyrForm.clickAlertBtn();
        System.out.println(alertBtnStatusNote);
        Assert.assertTrue(alertBtnStatusNote.contains("alert popup"), "HYR Alerts: Alert btn text didn't match!");

        String confirmBtnStatusNote = hyrForm.clickConfirmBtn();
        System.out.println(confirmBtnStatusNote);
        Assert.assertTrue(confirmBtnStatusNote.contains("pressed Cancel"), "HYR Alerts: Confirm btn text didn't match!");

        String promptBtnStatusNote = hyrForm.clickPromptBtn("Final step of this task");
        System.out.println(promptBtnStatusNote);
        Assert.assertTrue(promptBtnStatusNote.contains("Final step of this task"), "HYR Alerts: Prompt btn text didn't match!");
    }
}
