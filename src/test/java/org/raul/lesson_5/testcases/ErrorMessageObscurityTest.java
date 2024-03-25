package org.raul.lesson_5.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/* Testcase ID: L021 */
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
