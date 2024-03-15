package org.raul.lesson_5.testcases;

import org.openqa.selenium.WebDriver;
import org.raul.listener.AllureTestListener;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.*;

/*
 * Testcase ID: L03
 * 2. Доделать по три автотеста из каждого модуля, на которые писали тест-кейсы в лекции 9.
 * */
@Listeners({AllureTestListener.class})
public class UsernameDuplicationTest {
    private final static String URL = "https://qa-course-01.andersenlab.com/registration";

    private WebDriver driver;
    private UsernameDuplication duplication;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
        duplication = new UsernameDuplication(driver);
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(dataProvider = "registration")
    public void verifyRegistrationPageInputFields(String fName, String lName, String birthdate,
                                                  String email, String password, String confirmPassword) {
        duplication.inputName(fName);
        duplication.inputLastName(lName);
        duplication.inputBirthday(birthdate);
        duplication.inputEmail(email);
        duplication.inputPassword(password);
        duplication.inputConfirmPassword(confirmPassword);

        Assert.assertFalse(duplication.isDuplicateAllowed(), "Duplicate username shouldn't be allowed!");
    }

    @DataProvider(name = "registration")
    public Object[][] registrationData() {
        return new Object[][]{
                {"Elizabeth", "Keen", "03/23/2000", "mboone15@example.com", "mbmb.123456", "mbmb.123456"}
        };
    }
}
