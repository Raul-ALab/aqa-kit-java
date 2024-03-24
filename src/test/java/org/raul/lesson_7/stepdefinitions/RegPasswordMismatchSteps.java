package org.raul.lesson_7.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.raul.lesson_7.RegPasswordMismatch;
import org.raul.utils.DriverSetUp2;
import org.testng.Assert;

public class RegPasswordMismatchSteps {
    private final static String URL = "https://qa-course-01.andersenlab.com/login";

    private WebDriver driver;
    private RegPasswordMismatch passMismatch;

    @Before
    public void setUp() {
        driver = DriverSetUp2.startDriver();
        passMismatch = new RegPasswordMismatch(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        driver.get(URL);
    }

    @Given("I click on registration button")
    public void iClickOnRegistrationButton() {
        passMismatch.clickRegistrationBtn();
    }

    @When("I am on registration page")
    public void iAmOnRegistrationPage() {
        Assert.assertTrue(passMismatch.isOnRegistrationPage(),
                "User is not on the registration page!");
    }

    @And("I enter {string} to FirstName field")
    public void iEnterFNameToFirstNameField(String fName) {
        passMismatch.inputName(fName);
    }

    @And("I enter {string} to LastName field")
    public void iEnterLNameToLastNameField(String lName) {
        passMismatch.inputLastName(lName);
    }

    @And("I enter {string} to Birthday field")
    public void iEnterBirthdateToBirthdayField(String birthdate) {
        passMismatch.inputBirthday(birthdate);
    }

    @And("I enter {string} to Email field")
    public void iEnterEmailToEmailField(String email) {
        passMismatch.inputEmail(email);
    }

    @And("I enter {string} to Password field")
    public void iEnterPasswordToPasswordField(String password) {
        passMismatch.inputPassword(password);
    }

    @And("I enter {string} to ConfirmPassword field")
    public void iEnterWrongPasswordToConfirmPasswordField(String wrongPassword) {
        passMismatch.inputConfirmPassword(wrongPassword);
    }

    @Then("I see error message")
    public void iSeeErrorMessage() {
        Assert.assertTrue(passMismatch.isErrorMessageVisible(),
                "There is no visible message!");
    }

    @And("I retrieve error message to validate")
    public void iRetrieveErrorMessageToValidate() {
        String expectedError = "Passwords must match";
        Assert.assertEquals(passMismatch.retrieveErrorMessageText(), expectedError);
    }
}
