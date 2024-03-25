package org.raul.lesson_5.testcases;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.raul.listener.AllureTestListener;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.*;

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
        driver = DriverSetUp.setUpChromeDriver();
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
    @Description("Test Case L021 : Same Error message.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Invalid email login error message same with wrong password error")
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
