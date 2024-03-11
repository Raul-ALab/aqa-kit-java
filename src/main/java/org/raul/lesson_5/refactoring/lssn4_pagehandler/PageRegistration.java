package org.raul.lesson_5.refactoring.lssn4_pagehandler;

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


    public PageRegistration(WebDriver driver) {
        this.driver = driver;
    }

    public String signUpHeader() {
        return driver.findElement(headerLocator).getText();
    }

    public void inputName(String name) {
        driver.findElement(fNameLocator).sendKeys(name);
    }

    public void inputLastName(String lName) {
        driver.findElement(lNameLocator).sendKeys(lName);
    }

    public void inputBirthday(String mmddyyyy) {
        driver.findElement(birthdayLocator).sendKeys(mmddyyyy);
    }

    public void inputEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public String inputConfirmPassword(String repeatPassword) {
        driver.findElement(confirmPassLocator).sendKeys(repeatPassword);
        return driver.findElement(confirmPassLocator).getAttribute("value");
    }
}