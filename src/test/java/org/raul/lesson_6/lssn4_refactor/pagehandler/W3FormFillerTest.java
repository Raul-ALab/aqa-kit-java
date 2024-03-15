package org.raul.lesson_6.lssn4_refactor.pagehandler;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.raul.lesson_6.refactoring_lssn4.pagehandler.W3FormFiller;
import org.raul.listener.AllureTestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestListener.class})
@Epic("W3School Page")
@Feature("Verify Registration Note")
public class W3FormFillerTest {
    private W3FormFiller w3Form;


    @BeforeClass
    public void setUp(WebDriver driver) {
        w3Form = new W3FormFiller(driver, "Raul", "Gurbanli");
        w3Form.switchToW3SchoolPage();
    }

    @Test
    @Description("Retrieve and verify registration success note.")
    @Severity(SeverityLevel.MINOR)
    @Story("Registration success note")
    public void verifyRegistrationSuccessNote() {
        w3Form.inputName();
        w3Form.inputLastName();
        w3Form.clickSubmit();

        String actualSuccessNote = w3Form.retrieveNoteText();
        System.out.println(actualSuccessNote);
        Assert.assertTrue(actualSuccessNote.contains("Note: This tutorial will not teach you"),
                "W3 form: 'Note' Text content didn't match!");
    }
}
