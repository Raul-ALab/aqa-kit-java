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
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
 * 1.	Добавьте аллюр-репортинг к нашим тестам: своему проекту.
 * 2.	Добавьте браузерные логи, если это потребуется.
 *
 * Testcase ID: L03
 * 2. Доделать по три автотеста из каждого модуля, на которые писали тест-кейсы в лекции 9.
 * */
@Listeners({AllureTestListener.class})
@Epic("Test Cases from lesson 9")
@Feature("Registration Page Testing")
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
    @Description("Test Case L03 : Registration with duplicate username.")
    @Severity(SeverityLevel.NORMAL)
    @Story("User is unable to complete registration with an existing username")
    @Link(name = "Test Cases file testcases(rev.1)", url = "src/test/resources/testcases(rev.1).xlsx")
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
