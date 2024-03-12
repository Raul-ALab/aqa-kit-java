package org.raul.utils;

import org.openqa.selenium.WebDriver;

public class HandleAdBlocker {
    public static void closeWelcomePage(WebDriver driver) {
        String pageUrl = driver.getCurrentUrl();
        if (pageUrl.contains("https://getadblock.com/")) {
            driver.close();
        }
    }
}
