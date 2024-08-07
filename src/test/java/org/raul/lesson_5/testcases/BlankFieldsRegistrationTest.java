package org.raul.lesson_5.testcases;

import org.openqa.selenium.WebDriver;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/* Testcase ID : L016 */
public class BlankFieldsRegistrationTest {
    private final static String URL = "https://qa-course-01.andersenlab.com/registration";

    private WebDriver driver;
    private BlankFieldsRegistration blankRegistration;


    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
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
    public void verifyBlankFieldRegistrationAttempt() {
        blankRegistration.clickSubmit();

        Assert.assertTrue(blankRegistration.isErrorDisplayed(),
                "Registration with blank fields shouldn't be possible!");
    }
}
