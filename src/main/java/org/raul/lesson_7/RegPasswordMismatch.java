package org.raul.lesson_7;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.raul.utils.AqaPageLocators;

import java.time.Duration;

/*
 * Test case ID: L01
 * */
public class RegPasswordMismatch implements AqaPageLocators {
    private WebDriver driver;
    private WebDriverWait wait;

    public RegPasswordMismatch(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @Step("Open registration page")
    public RegPasswordMismatch clickRegistrationBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(REGISTER_BTN_LOCATOR)).click();
        return this;
    }

    @Step("Check if on the the right page")
    public boolean isOnRegistrationPage() {
        WebElement header = driver.findElement(HEADER_LOCATOR);
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.getText().contains("Registration");
    }

    @Step("Enter first name: {fName}")
    public RegPasswordMismatch inputName(String fName) {
        driver.findElement(fNAME_LOCATOR).sendKeys(fName);
        return this;
    }

    @Step("Enter last name: {lName}")
    public RegPasswordMismatch inputLastName(String lName) {
        driver.findElement(lNAME_LOCATOR).sendKeys(lName);
        return this;
    }

    @Step("Enter birthdate: {birthdate}")
    public RegPasswordMismatch inputBirthday(String birthdate) {
        driver.findElement(DATE_OF_BIRTH_LOCATOR).sendKeys(birthdate);
        return this;
    }

    @Step("Enter email: {email}")
    public RegPasswordMismatch inputEmail(String email) {
        driver.findElement(EMAIL_LOCATOR).sendKeys(email);
        return this;
    }

    @Step("Enter password: {password}")
    public RegPasswordMismatch inputPassword(String password) {
        driver.findElement(PASSWORD_LOCATOR).sendKeys(password);
        return this;
    }

    @Step("Repeat password: {wrongPassword}")
    public RegPasswordMismatch inputConfirmPassword(String wrongPassword) {
        driver.findElement(CONFIRM_PASSWORD_LOCATOR).sendKeys(wrongPassword);
        driver.findElement(PASSWORD_LOCATOR).click(); // to leave current field for enabling the system to check values
        return this;
    }

    @Step("Check message visibility")
    public boolean isErrorMessageVisible() {
        WebElement mismatchError = driver.findElement(MISMATCH_ERROR_LOCATOR);
        wait.until(ExpectedConditions.visibilityOf(mismatchError)).isDisplayed();
        return mismatchError.getText().contains("must match");
    }

    @Step("Retrieve error message text")
    public String retrieveErrorMessageText() {
        WebElement mismatchError = driver.findElement(MISMATCH_ERROR_LOCATOR);
        return mismatchError.getText();
    }
}
