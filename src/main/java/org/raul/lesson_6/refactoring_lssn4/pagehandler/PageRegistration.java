package org.raul.lesson_6.refactoring_lssn4.pagehandler;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * 1. Добавьте аллюр-репортинг к нашим тестам: своему проекту.
 *
 * 3. Необходимо автоматизировать сценарий, который показан
 * на видео “Сценарий для автоматизации Лекция 12ч2.mp4.
 * */
public class PageRegistration {
    private WebDriver driver;

    @FindBy(xpath = "//h1[@class='text-2xl']")
    private WebElement headerLocator;
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


    public PageRegistration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Enter first name: {fName}")
    public PageRegistration inputName(String fName) {
        fNameLocator.sendKeys(fName);
        return this;
    }

    @Step("Enter last name: {lName}")
    public PageRegistration inputLastName(String lName) {
        lNameLocator.sendKeys(lName);
        return this;
    }

    @Step("Enter birthdate: {birthdate}")
    public PageRegistration inputBirthday(String birthdate) {
        birthdayLocator.sendKeys(birthdate);
        return this;
    }

    @Step("Enter email: {email}")
    public PageRegistration inputEmail(String email) {
        emailLocator.sendKeys(email);
        return this;
    }

    @Step("Enter password: {password}")
    public PageRegistration inputPassword(String password) {
        passwordLocator.sendKeys(password);
        return this;
    }

    @Step("Repeat password: {confirmPassword}")
    public PageRegistration inputConfirmPassword(String confirmPassword) {
        confirmPassLocator.sendKeys(confirmPassword);
        return this;
    }

    @Step("Get results: page header and password value")
    public String getHeaderAndPasswordValue() {
        String headerText = headerLocator.getText();
        String passwordValue = confirmPassLocator.getAttribute("value");

        return headerText + ":" + passwordValue;
    }
}
