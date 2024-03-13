package org.raul.lesson_5.lssn4_refactor.pagehandler;

import org.openqa.selenium.WebDriver;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.GuinnessFormFiller;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.PageOperations;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GuinnessFormFillerTest {
    private static final String URL = "https://www.guinnessworldrecords.com/account/register?";

    private WebDriver driver;
    private PageOperations pageOpts;
    private GuinnessFormFiller guinnessForm;


    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
        pageOpts = new PageOperations(driver);
        guinnessForm = new GuinnessFormFiller(driver);

        pageOpts.searchGuinnessByUrl(URL);
        guinnessForm.switchToGuinnessPage();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void isGuinnessAccountRegisterPage() {
        String title = "Guinness";
        Assert.assertTrue(driver.getTitle().contains(title), "Guinness title mismatch!");
    }

    @Test
    public void verifyPasswordMismatchError() {
        guinnessForm.inputLastName("Gurbanli");
        guinnessForm.inputName("Raul");
        guinnessForm.inputDayOfBirthday(14);
        guinnessForm.inputMonthOfBirthday(04);
        guinnessForm.inputYearOfBirthday(2014);
        String countryCode = guinnessForm.inputRegion("Azerbaijan");
        guinnessForm.inputState("Absheron");
        guinnessForm.inputEmail("anyemail@nomail.uk");
        guinnessForm.inputConfirmEmail("anyemail@nomail.uk");

        String getPassword = guinnessForm.inputPassword("a123654bc");
        String getConfirmPassword = guinnessForm.inputConfirmPassword("bc123654a");
        Assert.assertFalse(getPassword.equals(getConfirmPassword), "Password values are identical!");

        String expectedCountryCode = "AZ";
        Assert.assertEquals(countryCode, expectedCountryCode, "Different region value!");

        String expectedErrMessage = "'Confirm password' and 'Password' do not match.";
        String actualStatus = guinnessForm.retrieveErrorMessage();
        System.out.println(actualStatus);
        Assert.assertEquals(actualStatus, expectedErrMessage, "No error message is displayed!");
    }
}
