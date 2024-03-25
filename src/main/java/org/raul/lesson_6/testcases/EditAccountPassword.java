package org.raul.lesson_6.testcases;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/* Testcase ID : L017 */
public class EditAccountPassword extends LoginProcessor {
    private WebDriver driver;
    private WebDriverWait wait;

    public EditAccountPassword(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    @Step("Add new password: '{newPassword}' and confirm password: '{confirmPassword}'")
    public void updatePassword(String newPassword, String confirmPassword) {
        wait.until(ExpectedConditions.elementToBeClickable(editElement)).click();
        passwordLoginElement.sendKeys(newPassword);
        confirmPasswordElement.sendKeys(confirmPassword);
        clickSubmitBtn();
    }

    @Step("Click Logout button")
    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutElement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmLogoutElement)).click();
    }
}
