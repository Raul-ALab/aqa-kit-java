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
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
 * 1. Добавьте аллюр-репортинг к нашим тестам: своему проекту.
 * 2. Добавьте браузерные логи, если это потребуется.
 *
 * Testcase ID: L019
 * */
@Listeners({AllureTestListener.class})
@Epic("Test Cases from lesson 9")
@Feature("Login Page Testing")
@Owner("Rashad Raul")
public class LoginSessionTest {
    private final static String URL = "https://qa-course-01.andersenlab.com/login";

    private WebDriver driver;
    private LoginSession loginSession;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp2.startDriver();
        loginSession = new LoginSession(driver);
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(dataProvider = "loginData")
    @Description("Test Case L019 : User session persistence.")
    @Severity(SeverityLevel.MINOR)
    @Story("Unless explicitly logged out, browser sessions should be preserved")
    @Link(name = "Test Cases file testcases(rev.1)", url = "src/test/resources/testcases(rev.1).xlsx")
    public void verifyLoginSessionPersistsInNewWindow(String username, String password) {
        boolean loginStatus = loginSession.login(username, password);
        Assert.assertTrue(loginStatus, "Unsuccessful login attempt!");

        boolean isSessionPersists = loginSession.compareUsers();
        Assert.assertTrue(isSessionPersists, "Session isn't saved in a new window!");
    }

    @DataProvider(name = "loginData")
    public Object[][] existingData() {
        return new Object[][]{
                {"mboone12@example.com", "mbmb.123456"}
        };
    }
}
