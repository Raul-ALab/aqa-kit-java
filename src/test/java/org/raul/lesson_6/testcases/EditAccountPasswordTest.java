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
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
 * 1. Добавьте аллюр-репортинг к нашим тестам: своему проекту.
 * 2. Добавьте браузерные логи, если это потребуется.
 *
 * Testcase ID : L017
 * */
@Listeners({AllureTestListener.class})
@Epic("Test Cases from lesson 9")
@Feature("Edit Page Testing")
public class EditAccountPasswordTest {
    private final static String URL = "https://qa-course-01.andersenlab.com/login";

    private WebDriver driver;
    private EditAccountPassword editPassword;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp2.startDriver();
        editPassword = new EditAccountPassword(driver);
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(dataProvider = "existingCredentials")
    @Description("Login attempt success.")
    @Severity(SeverityLevel.BLOCKER)
    @Story("User can log in with correct credentials")
    public void loginToAccount(String username, String password) {
        boolean isLoggedIn = editPassword.login(username, password);
        Assert.assertTrue(isLoggedIn, "Unsuccessful login attempt!");
    }

    @Test(dataProvider = "updatedCredentials", dependsOnMethods = "loginToAccount")
    @Description("Test Case L017 : Successful completion of the password update.")
    @Severity(SeverityLevel.MINOR)
    @Story("User updates password and is able to log in with the new password")
    @Link(name = "Test Cases file testcases(rev.1)", url = "src/test/resources/testcases(rev.1).xlsx")
    public void updatePassword(String username, String newPassword, String confirmPassword) {
        editPassword.updatePassword(newPassword, confirmPassword);
        editPassword.clickLogout();
    }

    @DataProvider(name = "existingCredentials")
    public Object[][] existingData() {
        return new Object[][]{
                {"spader@example.com", "ab123456js.26"}
        };
    }

    @DataProvider(name = "updatedCredentials")
    public Object[][] updatedData() {
        return new Object[][]{
                {"spader@example.com", "ab123456js.27", "ab123456js.27"}
        };
    }
}
