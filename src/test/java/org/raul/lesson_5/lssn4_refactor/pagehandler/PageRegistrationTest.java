package org.raul.lesson_5.lssn4_refactor.pagehandler;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.PageRegistration;
import org.raul.listener.AllureTestListener;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.*;

/*
 * 1.	Добавьте аллюр-репортинг к нашим тестам: своему проекту.
 * 2.	Добавьте браузерные логи, если это потребуется.
 *
 * 3. Необходимо автоматизировать сценарий, который показан
 * на видео “Сценарий для автоматизации Лекция 12ч2.mp4.
 * */

@Listeners({AllureTestListener.class})
@Epic("QA course : andersenlab.com")
@Feature("Registration Page Entry Testing")
public class PageRegistrationTest {
    private final static String URL = "https://qa-course-01.andersenlab.com/registration";

    private WebDriver driver;
    private PageRegistration pageRegistration;


    @BeforeMethod
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
        pageRegistration = new PageRegistration(driver);
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(dataProvider = "data")
    @Description("Validate registration page field entries.")
    @Severity(SeverityLevel.NORMAL)
    @Story("User can fill out data entry fields")
    public void verifyRegistrationPageInputFields(String fName, String lName, String mmddyyyyBirthdate,
                                                  String email, String password, String confirmPassword) {
        String verifySignUpPage = pageRegistration.signUpHeader();
        pageRegistration.inputName(fName);
        pageRegistration.inputLastName(lName);
        pageRegistration.inputEmail(email);
        pageRegistration.inputBirthday(mmddyyyyBirthdate);
        pageRegistration.inputPassword(password);
        String confirmPasswordValue = pageRegistration.inputConfirmPassword(confirmPassword);

        String expectedFormHeader = "Registration";
        String expectedPassword = "a.park123";

        Assert.assertEquals(verifySignUpPage, expectedFormHeader, "Issue with loading 'Registration' page!");
        Assert.assertEquals(confirmPasswordValue, expectedPassword, "Confirm password mismatch!");
    }

    @DataProvider(name = "data")
    public Object[][] registrationData() {
        return new Object[][]{
                {"Alina", "Park", "03/23/2000", "apark@example.com", "a.park123", "a.park123"}
        };
    }
}
