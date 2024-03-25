package org.raul.lesson_7;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
 * Test case ID: L01
 * */
public class RegPasswordMismatch {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button/following-sibling::a[contains(@href, '/registration')]")
    private WebElement registrBtnElement;
    @FindBy(xpath = "//h1[@class='text-2xl']")
    private WebElement headerElement;
    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement fNameElement;
    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lNameElement;
    @FindBy(xpath = "//input[@name='dateOfBirth']")
    private WebElement birthdayElement;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailElement;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordElement;
    @FindBy(xpath = "//input[@name='passwordConfirmation']")
    private WebElement confirmPassElement;
    @FindBy(xpath = "//div/span[contains(text(), 'Passwords must match')]")
    private WebElement passMismatchErrorElement;


    public RegPasswordMismatch(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @Step("Open registration page")
    public RegPasswordMismatch clickRegistrationBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(registrBtnElement)).click();
        return this;
    }

    @Step("Check if on the the right page")
    public boolean isOnRegistrationPage() {
        wait.until(ExpectedConditions.visibilityOf(headerElement)).isDisplayed();
        return headerElement.getText().contains("Registration");
    }

    @Step("Enter first name: {fName}")
    public RegPasswordMismatch inputName(String fName) {
        fNameElement.sendKeys(fName);
        return this;
    }

    @Step("Enter last name: {lName}")
    public RegPasswordMismatch inputLastName(String lName) {
        lNameElement.sendKeys(lName);
        return this;
    }

    @Step("Enter birthdate: {birthdate}")
    public RegPasswordMismatch inputBirthday(String birthdate) {
        birthdayElement.sendKeys(birthdate);
        return this;
    }

    @Step("Enter email: {email}")
    public RegPasswordMismatch inputEmail(String email) {
        emailElement.sendKeys(email);
        return this;
    }

    @Step("Enter password: {password}")
    public RegPasswordMismatch inputPassword(String password) {
        passwordElement.sendKeys(password);
        return this;
    }

    @Step("Repeat password: {wrongPassword}")
    public RegPasswordMismatch inputConfirmPassword(String wrongPassword) {
        confirmPassElement.sendKeys(wrongPassword);
        passwordElement.click(); // to leave current field for enabling the system to check values
        return this;
    }

    @Step("Check message visibility")
    public boolean isErrorMessageVisible() {
        wait.until(ExpectedConditions.visibilityOf(passMismatchErrorElement)).isDisplayed();
        return passMismatchErrorElement.getText().contains("must match");
    }

    @Step("Retrieve error message text")
    public String retrieveErrorMessageText() {
        return passMismatchErrorElement.getText();
    }
}
