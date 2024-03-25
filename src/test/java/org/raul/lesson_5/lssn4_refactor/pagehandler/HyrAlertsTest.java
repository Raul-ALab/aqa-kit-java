package org.raul.lesson_5.lssn4_refactor.pagehandler;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.HyrAlerts;
import org.raul.listener.AllureTestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestListener.class})
@Epic("HYR Alerts")
@Feature("Alert Buttons Interaction Test")
public class HyrAlertsTest {
    private HyrAlerts hyrAlerts;


    @BeforeClass
    public void setUp(WebDriver driver) {
        hyrAlerts = new HyrAlerts(driver);
        hyrAlerts.switchToAlertsPage();
    }

    @Test
    @Description("Interact with alert buttons and retrieve status messages.")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Alerts button interaction")
    public void verifyAlertButtonsStatusMessages() {
        String alertBtnStatusNote = hyrAlerts.clickAlertBtn();
        System.out.println(alertBtnStatusNote);
        Assert.assertTrue(alertBtnStatusNote.contains("alert popup"), "HYR Alerts: Alert btn text didn't match!");

        String confirmBtnStatusNote = hyrAlerts.clickConfirmBtn();
        System.out.println(confirmBtnStatusNote);
        Assert.assertTrue(confirmBtnStatusNote.contains("pressed Cancel"), "HYR Alerts: Confirm btn text didn't match!");

        String promptBtnStatusNote = hyrAlerts.clickPromptBtn("Final step of this task");
        System.out.println(promptBtnStatusNote);
        Assert.assertTrue(promptBtnStatusNote.contains("Final step of this task"), "HYR Alerts: Prompt btn text didn't match!");
    }
}
