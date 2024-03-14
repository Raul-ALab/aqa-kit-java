package org.raul.lesson_5.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * Testcase ID: L014
 * 2. Доделать по три автотеста из каждого модуля, на которые писали тест-кейсы в лекции 9.
 * */
public class BlankFieldsLogin {
    WebDriver driver;

    private By signLocator = By.xpath("//button[@type='submit' and contains(text(), 'Sign in')]");
    private By errorLocator = By.xpath("//div//span[contains(text(), 'Required')]");


    public BlankFieldsLogin(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogin() {
        driver.findElement(signLocator).click();
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(errorLocator).isDisplayed();
    }
}
