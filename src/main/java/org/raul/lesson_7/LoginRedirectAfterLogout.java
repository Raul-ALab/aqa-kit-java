package org.raul.lesson_7;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.raul.utils.AqaPageLocators;

import java.time.Duration;

/*
 * Test case ID: L010
 * */
public class LoginRedirectAfterLogout implements AqaPageLocators {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginRedirectAfterLogout(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Step("Enter email: {email}")
    public LoginRedirectAfterLogout inputEmail(String email) {
        driver.findElement(EMAIL_LOCATOR).sendKeys(email);
        return this;
    }

    @Step("Enter password: {password}")
    public LoginRedirectAfterLogout inputPassword(String password) {
        driver.findElement(PASSWORD_LOCATOR).sendKeys(password);
        return this;
    }

    @Step("Click Sign in button")
    public LoginRedirectAfterLogout clickSignInBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(SIGN_IN_LOCATOR)).click();
        return this;
    }

    @Step("Check Logout button")
    public boolean isLoggedIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_LOCATOR));
        return driver.findElement(LOGOUT_LOCATOR).isDisplayed();
    }

    @Step("Click Logout button")
    public LoginRedirectAfterLogout clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(LOGOUT_LOCATOR)).click();
        return this;
    }

    @Step("Confirm logout")
    public LoginRedirectAfterLogout confirmYesToLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(CONFIRM_YES_LOCATOR)).click();
        return this;
    }

    @Step("Check if logged out")
    public boolean isLoggedOut() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SIGN_IN_LOCATOR));
        return driver.findElement(SIGN_IN_LOCATOR).isDisplayed();
    }

    @Step("Click back button")
    public LoginRedirectAfterLogout backButtonRedirect() {
        driver.navigate().back();
        return this;
    }

    @Step("Check page state after clicking on the back button")
    public boolean isBackToLogInPage() {
        return driver.findElements(LOGOUT_LOCATOR).isEmpty() ? false : true;
    }
}
