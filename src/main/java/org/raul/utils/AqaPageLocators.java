package org.raul.utils;

import org.openqa.selenium.By;

public interface AqaPageLocators {
    By EMAIL_LOCATOR = By.name("email");
    By PASSWORD_LOCATOR = By.name("password");
    By SIGN_IN_LOCATOR = By.xpath("//button[@type='submit']");
    By LOGOUT_LOCATOR = By.xpath("//div/p[text()='Logout']");
    By CONFIRM_YES_LOCATOR = By.xpath("//div/button[@label='Yes']");
    By ERROR_LOCATOR = By.xpath("//span[contains(text(), 'not valid')]");
}
