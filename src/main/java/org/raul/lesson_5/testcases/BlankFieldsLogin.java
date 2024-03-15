package org.raul.lesson_5.testcases;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
 * Testcase ID: L014
 * 2. Доделать по три автотеста из каждого модуля, на которые писали тест-кейсы в лекции 9.
 * */
public class BlankFieldsLogin {
    private WebDriver driver;
    private WebDriverWait wait;
    private By signLocator = By.xpath("//button[@type='submit' and contains(text(), 'Sign in')]");
    private By errorLocator = By.xpath("//div//span[contains(text(), 'Required')]");


    public BlankFieldsLogin(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    @Step("Click Submit button")
    public void clickLogin() {
        driver.findElement(signLocator).click();
    }

    @Step("Check error message")
    public boolean isErrorDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
        return driver.findElement(errorLocator).isDisplayed();
    }
}
