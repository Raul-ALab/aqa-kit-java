package org.raul.lesson_5.testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.raul.listener.AllureTestListener;
import org.raul.utils.DriverSetUp;
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
 * Testcase ID: L020
 * */
@Listeners({AllureTestListener.class})
@Epic("Test Cases from lesson 9")
@Feature("Login Page Testing")
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
    @Description("Test Case L020 : Login attempt with an invalid email.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Verify error message with an invalid email attempt")
    @Link(name = "Test Cases file testcases(rev.1)", url = "src/test/resources/testcases(rev.1).xlsx")
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
