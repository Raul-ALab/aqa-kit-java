package org.raul.lesson_5.lssn4_refactor.pagehandler;


import org.openqa.selenium.WebDriver;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.PageRegistration;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * Refactor:
 * 3. Необходимо автоматизировать сценарий, который показан
 * на видео “Сценарий для автоматизации Лекция 12ч2.mp4.
 * */
public class PageRegistrationTest {
    private final static String URL = "https://qa-course-01.andersenlab.com/registration";

    private WebDriver driver;
    private PageRegistration pageRegistration;


    @BeforeMethod
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
        pageRegistration = new PageRegistration(driver, "Alina", "Park", "03/23/2000",
                "apark@example.com", "a.park123", "a.park123");
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verifyRegistrationPageInputFields() {
        String verifySignUpPage = pageRegistration.signUpHeader();
        pageRegistration.inputName();
        pageRegistration.inputLastName();
        pageRegistration.inputEmail();
        pageRegistration.inputBirthday();
        pageRegistration.inputPassword();
        String confirmPasswordValue = pageRegistration.inputConfirmPassword();

        String expectedFormHeader = "Registration";
        String expectedPassword = "a.park123";

        Assert.assertEquals(verifySignUpPage, expectedFormHeader, "Issue with loading 'Registration' page!");
        Assert.assertEquals(confirmPasswordValue, expectedPassword, "Confirm password mismatch!");
    }
}
