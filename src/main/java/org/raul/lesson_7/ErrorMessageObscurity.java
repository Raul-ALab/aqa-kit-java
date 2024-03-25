package org.raul.lesson_7;

import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.raul.utils.AqaPageLocators;

import java.time.Duration;

/* Testcase ID: L021 */
public class ErrorMessageObscurity implements AqaPageLocators {
    private WebDriver driver;
    private WebDriverWait wait;

    public ErrorMessageObscurity(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @Step("Enter invalid email: {invalidEmail}")
    public ErrorMessageObscurity inputInvalidEmail(String invalidEmail) {
        driver.findElement(EMAIL_LOCATOR).sendKeys(invalidEmail);
        return this;
    }

    @Step("Enter valid password: {validPassword}")
    public ErrorMessageObscurity inputPassword(String validPassword) {
        driver.findElement(PASSWORD_LOCATOR).sendKeys(validPassword);
        return this;
    }

    @Step("Enter valid email: {validEmail}")
    public ErrorMessageObscurity inputEmail(String validEmail) {
        driver.findElement(EMAIL_LOCATOR).sendKeys(validEmail);
        return this;
    }

    @Step("Enter invalid password: {invalidPassword}")
    public ErrorMessageObscurity inputInvalidPassword(String invalidPassword) {
        driver.findElement(PASSWORD_LOCATOR).sendKeys(invalidPassword);
        return this;
    }

    @Step("Click sign in")
    public ErrorMessageObscurity clickSignInBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(SIGN_IN_LOCATOR)).click();
        return this;
    }

    @Step("Switch to another Tab")
    public ErrorMessageObscurity switchToAnotherTab() {
        driver.switchTo().newWindow(WindowType.TAB);
        return this;
    }

    @Step("Reopen login page")
    public ErrorMessageObscurity openLoginPage(String url) {
        driver.get(url);
        return this;
    }

    @Step("Get error message for comparison")
    public String getErrorMessageForInvalidCredentials() {
        try {
            WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_LOCATOR));
            return errorMessageElement.getText();
        } catch (TimeoutException e) {
            return "Error message didn't display!";
        }
    }
}
