package org.raul.lesson_5.testcases;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*Testcase ID: L018 */
public class EditAccountSwitchUrl {
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
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailValueElement;


    public EditAccountSwitchUrl(WebDriver driver) {
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

    public boolean clickEditAccount() {
        editElement.click();
        return driver.getCurrentUrl().contains("editAccount");
    }

    private void clickSubmitBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(submitElement)).click();
    }
}
