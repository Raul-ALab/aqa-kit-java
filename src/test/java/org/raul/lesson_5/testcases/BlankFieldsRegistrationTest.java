package org.raul.lesson_5.testcases;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.raul.listener.AllureTestListener;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
 * 1. Добавьте аллюр-репортинг к нашим тестам: своему проекту.
 * 2. Добавьте браузерные логи, если это потребуется.
 *
 * Testcase ID : L016
 * */
@Listeners({AllureTestListener.class})
@Epic("Test Cases from lesson 9")
@Feature("Registration Page Testing")
public class BlankFieldsRegistrationTest {
    private final static String URL = "https://qa-course-01.andersenlab.com/registration";

    private WebDriver driver;
    private BlankFieldsRegistration blankRegistration;


    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
        blankRegistration = new BlankFieldsRegistration(driver);

        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Description("Test Case L016 : Same Error message.")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyBlankFieldRegistrationAttempt() {
        blankRegistration.clickSubmit();

        Assert.assertTrue(blankRegistration.isErrorDisplayed(),
                "Registration with blank fields shouldn't be possible!");
    }
}
