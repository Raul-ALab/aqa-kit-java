package org.raul.lesson_5.testcases;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginProcessor {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@name='email']")
    protected WebElement emailLoginElement;
    @FindBy(xpath = "//input[@name='password']")
    protected WebElement passwordLoginElement;
    @FindBy(xpath = "//div//button[@type='submit']")
    protected WebElement submitElement;
    @FindBy(xpath = "//div//p[contains(text(), '@')]")
    protected WebElement loggedInEmailElement;

    public LoginProcessor(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        PageFactory.initElements(driver, this);
    }

    public boolean login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSubmitBtn();

        try {
            wait.until(ExpectedConditions.visibilityOf(loggedInEmailElement)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    private void enterUsername(String username) {
        emailLoginElement.sendKeys(username);
    }

    private void enterPassword(String password) {
        passwordLoginElement.sendKeys(password);
    }

    private void clickSubmitBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(submitElement)).click();
    }
}
