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
    @FindBy(xpath = "//div//a[text()='Edit account']")
    protected WebElement editElement;
    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    protected WebElement confirmPasswordElement;
    @FindBy(xpath = "//p[text()='Logout']")
    protected WebElement logoutElement;
    @FindBy(xpath = "//button[@style='background: red;'and @label='Yes']")
    protected WebElement confirmLogoutElement;

    public LoginProcessor(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        PageFactory.initElements(driver, this);
    }

    @Step("Execute login process")
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

    @Step("Enter username: {username}")
    private void enterUsername(String username) {
        emailLoginElement.sendKeys(username);
    }

    @Step("Enter password: {password}")
    private void enterPassword(String password) {
        passwordLoginElement.sendKeys(password);
    }

    @Step("Click Submit button")
    protected void clickSubmitBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(submitElement)).click();
    }
}
