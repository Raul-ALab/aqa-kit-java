package org.raul.lesson_5.testcases;

import org.openqa.selenium.WebDriver;
import org.raul.listener.AllureTestListener;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.*;

/*
 * 1. Добавьте аллюр-репортинг к нашим тестам: своему проекту.
 * 2. Добавьте браузерные логи, если это потребуется.
 *
 * Testcase ID: L019
 * */
@Listeners({AllureTestListener.class})
public class LoginSessionTest {
    private final static String URL = "https://qa-course-01.andersenlab.com/login";

    private WebDriver driver;
    private LoginSession loginSession;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
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
