package org.raul.lesson_5.testcases;

import org.openqa.selenium.WebDriver;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/* Testcase ID: L020 */
public class InvalidEmailLoginTest {
    private final static String URL = "https://qa-course-01.andersenlab.com/login";

    private WebDriver driver;
    private InvalidEmailLogin invalidEmail;


    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
        invalidEmail = new InvalidEmailLogin(driver);
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(dataProvider = "invalidEmail")
    public void verifyInvalidEmailLoginError(String alwaysWrong, String correctPassword) {
        invalidEmail.login(alwaysWrong, correctPassword);

        Assert.assertTrue(invalidEmail.isErrorDisplayed(), "User shouldn't be able to login with invalid email!");
    }

    @DataProvider(name = "invalidEmail")
    public Object[][] existingData() {
        return new Object[][]{
                {"nosuchemail@nomail.com", "ab123456js.22"}
        };
    }
}
