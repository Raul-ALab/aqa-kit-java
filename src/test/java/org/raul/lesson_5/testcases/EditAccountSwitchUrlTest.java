package org.raul.lesson_5.testcases;

import org.openqa.selenium.WebDriver;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
