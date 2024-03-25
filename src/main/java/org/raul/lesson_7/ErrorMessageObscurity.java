package org.raul.lesson_7;

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

    public ErrorMessageObscurity inputInvalidEmail(String invalidEmail) {
        driver.findElement(EMAIL_LOCATOR).sendKeys(invalidEmail);
        return this;
    }

    public ErrorMessageObscurity inputPassword(String validPassword) {
        driver.findElement(PASSWORD_LOCATOR).sendKeys(validPassword);
        return this;
    }

    public ErrorMessageObscurity inputEmail(String validEmail) {
        driver.findElement(EMAIL_LOCATOR).sendKeys(validEmail);
        return this;
    }

    public ErrorMessageObscurity inputInvalidPassword(String invalidPassword) {
        driver.findElement(PASSWORD_LOCATOR).sendKeys(invalidPassword);
        return this;
    }

    public ErrorMessageObscurity clickSignInBtn() {
        driver.findElement(SIGN_IN_LOCATOR).click();
        return this;
    }

    public ErrorMessageObscurity switchToAnotherTab() {
        driver.switchTo().newWindow(WindowType.TAB);
        return this;
    }

    public ErrorMessageObscurity openLoginPage(String url) {
        driver.get(url);
        return this;
    }

    public String errorMessageForInvalidCredentials() {
        try {
            WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_LOCATOR));
            return errorMessageElement.getText();
        } catch (TimeoutException e) {
            return "Error message didn't display!";
        }
    }
}
