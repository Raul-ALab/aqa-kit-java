package org.raul.lesson_6.lssn4_refactor.pagehandler;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.raul.lesson_6.refactoring_lssn4.pagehandler.GuinnessFormFiller;
import org.raul.listener.AllureTestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestListener.class})
@Epic("Guinness Page")
@Feature("Verify Password Error")
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
    @Description("Verify error message when confirm password doesn't match.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Password mismatch error during registration")
    public void verifyPasswordMismatchErrors() {
        Assert.assertFalse(getPassword.equals(getConfirmPassword), "Password values are identical!");

        String expectedErrMessage = "'Confirm password' and 'Password' do not match.";
        String actualStatus = guinnessForm.retrieveErrorMessage();
        System.out.println(actualStatus);
        Assert.assertEquals(actualStatus, expectedErrMessage, "There was an issue with error message!");
    }
}
