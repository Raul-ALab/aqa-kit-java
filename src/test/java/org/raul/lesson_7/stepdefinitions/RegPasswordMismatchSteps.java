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
        DriverSetUp2.quitDriver();
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get(URL);
    }

    @Given("I click on registration button")
    public void i_click_on_registration_button() {
        passMismatch.clickRegistrationBtn();
    }

    @When("I am on registration page")
    public void i_am_on_registration_page() {
        Assert.assertTrue(passMismatch.isOnRegistrationPage(),
                "User is not on the registration page!");
    }

    @And("I enter {string} to FirstName field")
    public void i_enter_name_to_first_name_field(String fName) {
        passMismatch.inputName(fName);
    }

    @And("I enter {string} to LastName field")
    public void i_enter_last_name_to_last_name_field(String lName) {
        passMismatch.inputLastName(lName);
    }

    @And("I enter {string} to Birthday field")
    public void i_enter_date_to_birthday_field(String birthdate) {
        passMismatch.inputBirthday(birthdate);
    }

    @And("I enter {string} to Email field")
    public void i_enter_email_to_email_field(String email) {
        passMismatch.inputEmail(email);
    }

    @And("I enter {string} to Password field")
    public void i_enter_pass_to_password_field(String password) {
        passMismatch.inputPassword(password);
    }

    @And("I enter {string} to ConfirmPassword field")
    public void i_enter_wrong_pass_to_confirm_password_field(String wrongPassword) {
        passMismatch.inputConfirmPassword(wrongPassword);
    }

    @Then("I see error message")
    public void i_see_error_message() {
        Assert.assertTrue(passMismatch.isErrorMessageVisible(),
                "There is no visible message!");
    }

    @And("I retrieve error message to validate")
    public void i_retrieve_error_message_to_validate() {
        String expectedError = "Passwords must match";
        Assert.assertEquals(passMismatch.retrieveErrorMessageText(), expectedError);
    }
}
