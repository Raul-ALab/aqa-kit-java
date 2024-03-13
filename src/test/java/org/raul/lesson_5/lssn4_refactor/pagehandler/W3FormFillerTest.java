package org.raul.lesson_5.lssn4_refactor.pagehandler;

import org.openqa.selenium.WebDriver;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.PageOperations;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.W3FormFiller;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class W3FormFillerTest {
    private final static String URL = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit";

    private WebDriver driver;
    private PageOperations pageOpts;
    private W3FormFiller w3Form;


    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
        pageOpts = new PageOperations(driver);
        w3Form = new W3FormFiller(driver, "Raul", "Gurbanli");

        pageOpts.searchW3ByUrl(URL);
        w3Form.switchToW3SchoolPage();
    }

    @Test
    public void isW3SchoolPage() {
        String title = "W3Schools";
        Assert.assertTrue(driver.getTitle().contains(title), "W3Schools title mismatch!");
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
