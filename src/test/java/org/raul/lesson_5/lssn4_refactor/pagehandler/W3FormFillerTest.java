package org.raul.lesson_5.lssn4_refactor.pagehandler;

import org.openqa.selenium.WebDriver;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.W3FormFiller;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class W3FormFillerTest {
    private W3FormFiller w3Form;


    @BeforeClass
    public void setUp(WebDriver driver) {
        w3Form = new W3FormFiller(driver, "Raul", "Gurbanli");
        w3Form.switchToW3SchoolPage();
    }

    @Test
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
