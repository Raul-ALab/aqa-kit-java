package org.raul.lesson_5.refactoring_lssn4.pagehandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * Refactor:
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

    private String name;
    private String lName;
    private String birthdate;
    private String email;
    private String password;
    private String confirmPassword;

    public PageRegistration(WebDriver driver, String name, String lName,
                            String mmddyyyyBirthdate, String email, String password, String confirmPassword) {
        this.driver = driver;
        this.name = name;
        this.lName = lName;
        this.birthdate = mmddyyyyBirthdate;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String signUpHeader() {
        return driver.findElement(headerLocator).getText();
    }

    public void inputName() {
        driver.findElement(fNameLocator).sendKeys(this.name);
    }

    public void inputLastName() {
        driver.findElement(lNameLocator).sendKeys(this.lName);
    }

    public void inputBirthday() {
        driver.findElement(birthdayLocator).sendKeys(this.birthdate);
    }

    public void inputEmail() {
        driver.findElement(emailLocator).sendKeys(this.email);
    }

    public void inputPassword() {
        driver.findElement(passwordLocator).sendKeys(this.password);
    }

    public String inputConfirmPassword() {
        driver.findElement(confirmPassLocator).sendKeys(confirmPassword);
        return driver.findElement(confirmPassLocator).getAttribute("value");
    }
}
