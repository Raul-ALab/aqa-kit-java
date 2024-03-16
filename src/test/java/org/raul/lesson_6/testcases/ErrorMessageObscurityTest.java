package org.raul.lesson_6.testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.raul.listener.AllureTestListener;
import org.raul.utils.DriverSetUp2;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
 * 1. Добавьте аллюр-репортинг к нашим тестам: своему проекту.
 * 2. Добавьте браузерные логи, если это потребуется.
 *
 * Testcase ID: L021
 * */
@Listeners({AllureTestListener.class})
@Epic("Test Cases from lesson 9")
@Feature("Login Page Testing")
public class ErrorMessageObscurityTest {
    private final static String URL = "https://qa-course-01.andersenlab.com/login";

    private WebDriver driver;
    private ErrorMessageObscurity obscurity;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp2.startDriver();
        obscurity = new ErrorMessageObscurity(driver);
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(dataProvider = "invalidDetails")
    @Description("Test Case L021 : Security through obscurity approach.")
    @Severity(SeverityLevel.NORMAL)
    @Story("Verify that invalid email and invalid password login attempts returns a generic error message in both cases")
    @Link(name = "Test Cases file testcases(rev.1)", url = "src/test/resources/testcases(rev.1).xlsx")
    public void verifyInvalidEmailLoginError(String wrongE, String correctP, String correctE, String wrongP) {
        String emailError = obscurity.invalidEmailAttempt(wrongE, correctP);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL);

        String passwordError = obscurity.invalidPasswordAttempt(correctE, wrongP);
        Assert.assertTrue(emailError.equals(passwordError), "Error message should be generic for failed attempts!");
    }

    @DataProvider(name = "invalidDetails")
    public Object[][] loginData1() {
        return new Object[][]{
                {"nosuchemail@nomail.com", "mbmb.123456", "mboone10@example.com", "wrongPass"}
        };
    }
}
