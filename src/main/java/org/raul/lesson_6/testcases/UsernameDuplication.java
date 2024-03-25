package org.raul.lesson_6.testcases;

import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
 * Testcase ID: L03
 * 2. Доделать по три автотеста из каждого модуля, на которые писали тест-кейсы в лекции 9.
 * */
public class UsernameDuplication {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement fNameLocator;
    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lNameLocator;
    @FindBy(xpath = "//input[@name='dateOfBirth']")
    private WebElement birthdayLocator;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailLocator;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordLocator;
    @FindBy(xpath = "//input[@name='passwordConfirmation']")
    private WebElement confirmPassLocator;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitLocator;

    public UsernameDuplication(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        PageFactory.initElements(driver, this);
    }

    @Step("Enter first name: {fName}")
    public UsernameDuplication inputName(String fName) {
        fNameLocator.sendKeys(fName);
        return this;
    }

    @Step("Enter last name: {lName}")
    public UsernameDuplication inputLastName(String lName) {
        lNameLocator.sendKeys(lName);
        return this;
    }

    @Step("Enter birthdate: {birthdate}")
    public UsernameDuplication inputBirthday(String birthdate) {
        birthdayLocator.sendKeys(birthdate);
        emailLocator.click(); // to dismiss calendar
        return this;
    }

    @Step("Enter email: {email}")
    public UsernameDuplication inputEmail(String email) {
        emailLocator.sendKeys(email);
        return this;
    }

    @Step("Enter password: {password}")
    public UsernameDuplication inputPassword(String password) {
        passwordLocator.sendKeys(password);
        return this;
    }

    @Step("Confirm password: '{confirmPassword}'")
    public UsernameDuplication inputConfirmPassword(String confirmPassword) {
        confirmPassLocator.sendKeys(confirmPassword);
        return this;
    }

    @Step("Click Submit button")
    public UsernameDuplication clickSubmit() {
        submitLocator.click();
        return this;
    }

    @Step("Check error message by URL state")
    public boolean isDuplicateAllowed() {
        String registrationUrl = "registration";
        try {
            wait.until(ExpectedConditions.not(ExpectedConditions.urlContains(registrationUrl)));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}
