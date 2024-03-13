package org.raul.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleCookies {
    public static void acceptCookiesIfPresent(WebDriver driver, By cookieLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        boolean isPresent = wait.until(ExpectedConditions.elementToBeClickable(cookieLocator)).isDisplayed();
        if (isPresent) {
            driver.findElement(cookieLocator).click();
        }
    }
}
