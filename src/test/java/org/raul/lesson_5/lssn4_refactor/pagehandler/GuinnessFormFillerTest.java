package org.raul.lesson_5.lssn4_refactor.pagehandler;

import org.openqa.selenium.WebDriver;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.GuinnessFormFiller;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GuinnessFormFillerTest {
    private GuinnessFormFiller guinnessForm;

    private String getPassword;
    private String getConfirmPassword;


    @BeforeClass
    public void setUp(WebDriver driver) {
        guinnessForm = new GuinnessFormFiller(driver);
        guinnessForm.switchToGuinnessPage();

        guinnessForm.inputLastName("Gurbanli");
        guinnessForm.inputName("Raul");
        guinnessForm.inputDayOfBirthday(14);
        guinnessForm.inputMonthOfBirthday(04);
        guinnessForm.inputYearOfBirthday(2014);
        guinnessForm.inputRegion("Azerbaijan");
        guinnessForm.inputState("Absheron");
        guinnessForm.inputEmail("anyemail@nomail.uk");
        guinnessForm.inputConfirmEmail("anyemail@nomail.uk");
        getPassword = guinnessForm.inputPassword("a123654bc");
        getConfirmPassword = guinnessForm.inputConfirmPassword("bc123654ba");
    }

    @Test
    public void verifyPasswordMismatchErrors() {
        Assert.assertFalse(getPassword.equals(getConfirmPassword), "Password values are identical!");

        String expectedErrMessage = "'Confirm password' and 'Password' do not match.";
        String actualStatus = guinnessForm.retrieveErrorMessage();
        System.out.println(actualStatus);
        Assert.assertEquals(actualStatus, expectedErrMessage, "There was an issue with error message!");
    }
}
