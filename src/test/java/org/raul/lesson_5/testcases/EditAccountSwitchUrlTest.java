package org.raul.lesson_5.testcases;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.raul.listener.AllureTestListener;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.*;

/*
 * 1. Добавьте аллюр-репортинг к нашим тестам: своему проекту.
 * 2. Добавьте браузерные логи, если это потребуется.
 *
 * */
@Listeners({AllureTestListener.class})
@Epic("Test Cases from lesson 9")
@Feature("Edit Page Testing")
public class EditAccountSwitchUrlTest {
    private final static String URL = "https://qa-course-01.andersenlab.com/login";

    private WebDriver driver;
    private EditAccountSwitchUrl urlSwitch;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
        urlSwitch = new EditAccountSwitchUrl(driver);
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(dataProvider = "loginData")
    @Description("Test Case L021 : Same Error message.")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyEditBtnSwitchesPage(String username, String password) {
        boolean loginStatus = urlSwitch.login(username, password);
        Assert.assertTrue(loginStatus, "Unsuccessful login attempt!");

        boolean actualUrl = urlSwitch.clickEditAccount();
        Assert.assertTrue(actualUrl, "editAccount button fails to change URL to edit page!");
    }

    @DataProvider(name = "loginData")
    public Object[][] existingData() {
        return new Object[][]{
                {"mboone10@example.com", "mbmb.123456"}
        };
    }
}
