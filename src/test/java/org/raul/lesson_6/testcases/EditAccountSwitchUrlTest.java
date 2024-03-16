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
 * Testcase ID: L018
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
        driver = DriverSetUp2.startDriver();
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
    @Description("Test Case L018 : Updated URL with the 'edit account' button.")
    @Severity(SeverityLevel.MINOR)
    @Story("'Edit Account' button should take the user to a new page with the correct URL for editing account details.")
    @Link(name = "Test Cases file testcases(rev.1)", url = "src/test/resources/testcases(rev.1).xlsx")
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
