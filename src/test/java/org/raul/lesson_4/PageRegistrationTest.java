package org.raul.lesson_4;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.raul.lesson_4.pagehandler.PageRegistration;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * 3. Необходимо автоматизировать сценарий, который показан
 * на видео “Сценарий для автоматизации Лекция 12ч2.mp4.
 * */
public class PageRegistrationTest {
    private final static String URL = "https://qa-course-01.andersenlab.com/registration";

    private WebDriver driver;
    private PageRegistration pageRegistration;

    private By emailLocator = By.name("email");
    private By confirmPasswordLocator = By.name("passwordConfirmation");
    private By fnameLocator = By.name("firstName");
    private By lnameLocator = By.name("lastName");


    @BeforeMethod
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
        pageRegistration = new PageRegistration();

        pageRegistration.setName("Alina");
        pageRegistration.setSurname("Park");
        pageRegistration.setEmail("apark@example.com");
        pageRegistration.setBirthdate("02/09/1999");
        pageRegistration.setPassword("a.park123");
        pageRegistration.setConfirmPassword("a.park123");
    }

    @Test
    public void verifyRegistrationPageForm() {
        pageRegistration.registrationSuccess(driver, URL);

        String emailFieldValidation = driver.findElement(emailLocator).getAttribute("value");
        Assert.assertEquals(emailFieldValidation, pageRegistration.getEmail(), "Email doesn't match!");

        String confirmPasswordMatch = driver.findElement(confirmPasswordLocator).getAttribute("value");
        boolean isPasswordMatch = pageRegistration.getPassword().equalsIgnoreCase(confirmPasswordMatch);
        Assert.assertTrue(isPasswordMatch, "Confirm password field is incorrect!");

        Assert.assertNotNull(driver.findElement(fnameLocator).getAttribute("value"), "Name field is null!");
        Assert.assertNotNull(driver.findElement(lnameLocator).getAttribute("value"), "Last name field is null!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
