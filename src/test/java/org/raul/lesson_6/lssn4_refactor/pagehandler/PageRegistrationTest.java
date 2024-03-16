package org.raul.lesson_6.lssn4_refactor.pagehandler;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.raul.lesson_6.refactoring_lssn4.pagehandler.PageRegistration;
import org.raul.listener.AllureTestListener;
import org.raul.utils.DriverSetUp2;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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


    @BeforeMethod
    public void setUp() {
        driver = DriverSetUp2.startDriver();
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
                                                  String email, String password, String confirmPassword,
                                                  String expectedPassword, String expectedFormHeader) {

        String getResults = new PageRegistration(driver)
                .inputName(fName)
                .inputLastName(lName)
                .inputBirthday(mmddyyyyBirthdate)
                .inputEmail(email)
                .inputPassword(password)
                .inputConfirmPassword(confirmPassword)
                .getHeaderAndPasswordValue();

        String[] splitForAssert = getResults.split(":"); // 0-header; 1-passValue

        Assert.assertEquals(splitForAssert[0], expectedFormHeader, "Issue with loading 'Registration' page!");
        Assert.assertEquals(splitForAssert[1], expectedPassword, "Confirm password mismatch!");
    }

    @DataProvider(name = "data")
    public Object[][] registrationData() {
        return new Object[][]{
                {"Alina", "Park", "03/23/2000", "apark@example.com",
                        "a.park123", "a.park123", "a.park123", "Registration"}};
    }
}
