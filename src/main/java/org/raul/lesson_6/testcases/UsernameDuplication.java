package org.raul.lesson_6.testcases;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
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

    private By fNameLocator = By.xpath("//input[@name='firstName']");
    private By lNameLocator = By.xpath("//input[@name='lastName']");
    private By birthdayLocator = By.xpath("//input[@name='dateOfBirth']");
    private By emailLocator = By.xpath("//input[@name='email']");
    private By passwordLocator = By.xpath("//input[@name='password']");
    private By confirmPassLocator = By.xpath("//input[@name='passwordConfirmation']");
    private By submitLocator = By.xpath("//button[@type='submit']");


    public UsernameDuplication(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    @Step("Enter first name: {fName}")
    public void inputName(String fName) {
        driver.findElement(fNameLocator).sendKeys(fName);
    }

    @Step("Enter last name: {lName}")
    public void inputLastName(String lName) {
        driver.findElement(lNameLocator).sendKeys(lName);
    }

    @Step("Enter birthdate: {birthdate}")
    public void inputBirthday(String birthdate) {
        driver.findElement(birthdayLocator).sendKeys(birthdate);
        driver.findElement(emailLocator).click(); // to dismiss calendar
    }

    @Step("Enter email: {email}")
    public void inputEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
    }

    @Step("Enter password: {password}")
    public void inputPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    @Step("Confirm password: '{confirmPassword}', and click Submit button")
    public void inputConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPassLocator).sendKeys(confirmPassword);
        driver.findElement(submitLocator).click();
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
