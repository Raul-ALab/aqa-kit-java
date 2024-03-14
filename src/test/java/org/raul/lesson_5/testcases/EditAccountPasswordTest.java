package org.raul.lesson_5.testcases;

import org.openqa.selenium.WebDriver;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/* Testcase ID : L017 */
public class EditAccountPasswordTest {
    private final static String URL = "https://qa-course-01.andersenlab.com/login";

    private WebDriver driver;
    private EditAccountPassword editPassword;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
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
    public void loginToAccount(String username, String password) {
        boolean isLoggedIn = editPassword.login(username, password);
        Assert.assertTrue(isLoggedIn, "Unsuccessful login attempt!");
    }

    @Test(dataProvider = "updatedCredentials", dependsOnMethods = "loginToAccount")
    public void updatePassword(String username, String newPassword, String confirmPassword) {
        editPassword.updatePassword(newPassword, confirmPassword);
        editPassword.clickLogout();
    }

    @DataProvider(name = "existingCredentials")
    public Object[][] existingData() {
        return new Object[][]{
                {"spader@example.com", "ab123456js.23"}
        };
    }

    @DataProvider(name = "updatedCredentials")
    public Object[][] updatedData() {
        return new Object[][]{
                {"spader@example.com", "ab123456js.24", "ab123456js.24"}
        };
    }
}
