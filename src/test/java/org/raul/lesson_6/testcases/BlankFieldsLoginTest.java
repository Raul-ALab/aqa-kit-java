package org.raul.lesson_6.testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
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
 * Testcase ID: L014
 * 2. Доделать по три автотеста из каждого модуля, на которые писали тест-кейсы в лекции 9.
 * */
@Listeners({AllureTestListener.class})
@Epic("Test Cases from lesson 9")
@Feature("Login Page Testing")
public class BlankFieldsLoginTest {
    private final static String URL = "https://qa-course-01.andersenlab.com/login";

    private WebDriver driver;
    private BlankFieldsLogin blankLogin;


    @BeforeClass
    public void setUp() {
        driver = DriverSetUp2.startDriver();
        blankLogin = new BlankFieldsLogin(driver);
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Description("Test Case L014 : Login attempt with blank fields.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Verify that user is unable to login with blank fields")
    @Link(name = "Test Cases file testcases(rev.1)", url = "src/test/resources/testcases(rev.1).xlsx")
    public void verifyBlankFieldLoginAttempt() {
        blankLogin.clickLogin();

        Assert.assertTrue(blankLogin.isErrorDisplayed(), "Login with blank fields shouldn't be possible!");
    }
}
