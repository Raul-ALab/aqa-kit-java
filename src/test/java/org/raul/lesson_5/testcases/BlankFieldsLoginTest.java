package org.raul.lesson_5.testcases;

import org.openqa.selenium.WebDriver;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * Testcase ID: L014
 * 2. Доделать по три автотеста из каждого модуля, на которые писали тест-кейсы в лекции 9.
 * */
public class BlankFieldsLoginTest {
    private final static String URL = "https://qa-course-01.andersenlab.com/login";

    private WebDriver driver;
    private BlankFieldsLogin blankLogin;


    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
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
    public void verifyBlankFieldLoginAttempt() {
        blankLogin.clickLogin();

        Assert.assertTrue(blankLogin.isErrorDisplayed(), "Login with blank fields shouldn't be possible!");
    }
}
