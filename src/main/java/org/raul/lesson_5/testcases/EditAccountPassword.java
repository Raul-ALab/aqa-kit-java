package org.raul.lesson_5.testcases;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/* Testcase ID : L017 */
public class EditAccountPassword {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailLoginElement;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordLoginElement;
    @FindBy(xpath = "//div//button[@type='submit']")
    private WebElement submitElement;
    @FindBy(xpath = "//div//a[text()='Edit account']")
    private WebElement editElement;
    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    private WebElement confirmPasswordElement;
    @FindBy(xpath = "//p[text()='Logout']")
    private WebElement logoutElement;
    @FindBy(xpath = "//button[@style='background: red;'and @label='Yes']")
    private WebElement confirmLogoutElement;

    public EditAccountPassword(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        PageFactory.initElements(driver, this);
    }

    public boolean login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(emailLoginElement)).sendKeys(username);
        passwordLoginElement.sendKeys(password);
        clickSubmitBtn();
        try {
            wait.until(ExpectedConditions.visibilityOf(editElement)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public void updatePassword(String newPassword, String confirmPassword) {
        wait.until(ExpectedConditions.elementToBeClickable(editElement)).click();
        passwordLoginElement.sendKeys(newPassword);
        confirmPasswordElement.sendKeys(confirmPassword);
        clickSubmitBtn();
    }

    private void clickSubmitBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(submitElement)).click();
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutElement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmLogoutElement)).click();
    }
}
