package org.raul.lesson_6.testcases;

import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/* Testcase ID: L019 */
public class LoginSession extends LoginProcessor {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginSession(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    @Step("Check user equality in two windows")
    public boolean compareUsers() {
        String initialWindowUser = getUsername();
        String secondWindowUser = "";

        boolean isSwitchSuccessful = copyUrlToNewWindow();
        if (isSwitchSuccessful) {
            secondWindowUser = getUsername();
        } else {
            return false;
        }
        return initialWindowUser.equals(secondWindowUser);
    }

    @Step("Enter URL in the new window")
    public boolean copyUrlToNewWindow() {
        String currentUrl = driver.getCurrentUrl();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(currentUrl);
        try {
            wait.until(ExpectedConditions.visibilityOf(loggedInEmailElement)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    @Step("Retrieve username info from the current session")
    private String getUsername() {
        return loggedInEmailElement.getText();
    }
}
