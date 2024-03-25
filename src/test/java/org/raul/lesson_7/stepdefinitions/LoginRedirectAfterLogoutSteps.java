package org.raul.lesson_7.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.raul.lesson_7.LoginRedirectAfterLogout;
import org.raul.utils.DriverSetUp2;
import org.testng.Assert;

public class LoginRedirectAfterLogoutSteps {
    private final static String URL = "https://qa-course-01.andersenlab.com/login";

    private WebDriver driver;
    private LoginRedirectAfterLogout loginRedirect;

    @Before
    public void setUp() {
        driver = DriverSetUp2.startDriver();
        loginRedirect = new LoginRedirectAfterLogout(driver);
    }

    @After
    public void tearDown() {
        DriverSetUp2.quitDriver();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get(URL);
    }

    @When("I enter {string} and {string} to Email and Password fields")
    public void i_enter_and_to_email_and_password_fields(String email, String password) {
        loginRedirect
                .inputEmail(email)
                .inputPassword(password);
    }

    @And("I click on Sign in button")
    public void i_click_on_sign_in_button() {
        loginRedirect.clickSignInBtn();
    }

    @And("I am logged in")
    public void i_am_logged_in() {
        Assert.assertTrue(loginRedirect.isLoggedIn(), "You're not logged in!");
    }

    @Then("I click on Logout and Yes to confirm logout")
    public void i_click_on_logout_yes_to_confirm_logout() {
        loginRedirect
                .clickLogout()
                .confirmYesToLogout();
    }

    @And("I logged out")
    public void i_logged_out() {
        Assert.assertTrue(loginRedirect.isLoggedOut(), "You're not logged out yet!");
    }

    @Then("I navigate back with back button")
    public void i_navigate_back_with_back_button() {
        loginRedirect.backButtonRedirect();
    }

    @And("Logged-in account page should not be accessible.")
    public void logged_in_account_page_should_not_be_accessible() {
        Assert.assertFalse(loginRedirect.isBackToLogInPage());
    }
}
