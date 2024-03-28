package org.raul.lesson_6.testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.raul.listener.AllureTestListener;
import org.raul.utils.DriverSetUp2;
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
@Owner("Rashad Raul")
public class BlankFieldsRegistrationTest {
    private final static String URL = "https://qa-course-01.andersenlab.com/registration";

    private WebDriver driver;
    private BlankFieldsRegistration blankRegistration;


    @BeforeClass
    public void setUp() {
        driver = DriverSetUp2.startDriver();
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
    @Description("Test Case L016 : Registration attempt with blank fields.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Verify that user is unable to complete registration with blank fields")
    @Link(name = "Test Cases file testcases(rev.1)", url = "src/test/resources/testcases(rev.1).xlsx")
    public void verifyBlankFieldRegistrationAttempt() {
        blankRegistration.clickSubmit();

        Assert.assertTrue(blankRegistration.isErrorDisplayed(),
                "Registration with blank fields shouldn't be possible!");
    }
}
