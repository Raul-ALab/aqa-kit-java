package org.raul.lesson_5.refactoring_lssn4.pagehandler;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * 1. Добавьте аллюр-репортинг к нашим тестам: своему проекту.
 *
 * 3. Необходимо автоматизировать сценарий, который показан
 * на видео “Сценарий для автоматизации Лекция 12ч2.mp4.
 * */
public class PageRegistration {
    private WebDriver driver;

    private By headerLocator = By.xpath("//h1[@class='text-2xl']");
    private By fNameLocator = By.xpath("//input[@name='firstName']");
    private By lNameLocator = By.xpath("//input[@name='lastName']");
    private By birthdayLocator = By.xpath("//input[@name='dateOfBirth']");
    private By emailLocator = By.xpath("//input[@name='email']");
    private By passwordLocator = By.xpath("//input[@name='password']");
    private By confirmPassLocator = By.xpath("//input[@name='passwordConfirmation']");


    public PageRegistration(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get page header text")
    public String signUpHeader() {
        return driver.findElement(headerLocator).getText();
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
    }

    @Step("Enter email: {email}")
    public void inputEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
    }

    @Step("Enter password: {password}")
    public void inputPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    @Step("Repeat password: {confirmPassword}")
    public String inputConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPassLocator).sendKeys(confirmPassword);
        return driver.findElement(confirmPassLocator).getAttribute("value");
    }
}
