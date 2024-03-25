package org.raul.lesson_7.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.raul.lesson_7.ErrorMessageObscurity;
import org.raul.utils.DriverSetUp2;
import org.testng.Assert;

public class ErrorMessageObscuritySteps {
    private final static String URL = "https://qa-course-01.andersenlab.com/login";

    private WebDriver driver;
    private ErrorMessageObscurity errorMessage;

    private String invalidEmailError;
    private String invalidPasswordError;

    @Before
    public void setUp() {
        driver = DriverSetUp2.startDriver();
        errorMessage = new ErrorMessageObscurity(driver);
    }

    @After
    public void tearDown() {
        DriverSetUp2.quitDriver();
    }

    @Given("The login page is accessed")
    public void the_login_page_is_accessed() {
        driver.get(URL);
    }

    @When("I input invalid {string} email and valid {string} password")
    public void i_input_invalid_email_and_valid_password(String invalidEmail, String password) {
        errorMessage
                .inputInvalidEmail(invalidEmail)
                .inputPassword(password);
    }

    @And("I click Sign in button")
    public void i_click_sign_in_button() {
        errorMessage.clickSignInBtn();
    }

    @Then("I should get an invalid credentials error for invalid email")
    public void i_should_get_an_invalid_credentials_error_for_invalid_email() {
        invalidEmailError = errorMessage.getErrorMessageForInvalidCredentials();
    }

    @And("I switch to a new tab to reopen login page")
    public void i_switch_to_a_new_tab_to_reopen_login_page() {
        errorMessage
                .switchToAnotherTab()
                .openLoginPage(URL);
    }

    @When("I input correct {string} email and invalid {string} password")
    public void i_input_correct_email_and_invalid_password(String email, String invalidPassword) {
        errorMessage
                .inputEmail(email)
                .inputInvalidPassword(invalidPassword);
    }

    @Then("I should get an invalid credentials error for invalid password")
    public void i_should_get_an_invalid_credentials_error_for_invalid_password() {
        invalidPasswordError = errorMessage.getErrorMessageForInvalidCredentials();
    }

    @And("Error messages similarity from both cases is verified")
    public void error_messages_similarity_from_both_cases_is_verified() {
        Assert.assertTrue(invalidEmailError.equals(invalidPasswordError),
                "Invalid error messages should be identical!");
    }
}
