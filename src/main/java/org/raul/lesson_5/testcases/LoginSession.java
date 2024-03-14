package org.raul.lesson_5.testcases;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSession extends LoginProcessor {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginSession(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

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

    private String getUsername() {
        return loggedInEmailElement.getText();
    }
}
