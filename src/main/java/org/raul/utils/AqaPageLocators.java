package org.raul.utils;

import org.openqa.selenium.By;

public interface AqaPageLocators {
    By EMAIL_LOCATOR = By.name("email");
    By PASSWORD_LOCATOR = By.name("password");
    By CONFIRM_PASSWORD_LOCATOR = By.name("passwordConfirmation");
    By SIGN_IN_LOCATOR = By.xpath("//button[@type='submit']");
    By LOGOUT_LOCATOR = By.xpath("//div/p[text()='Logout']");
    By CONFIRM_YES_LOCATOR = By.xpath("//div/button[@label='Yes']");
    By ERROR_LOCATOR = By.xpath("//span[contains(text(), 'not valid')]");
    By MISMATCH_ERROR_LOCATOR = By.xpath("//div/span[contains(text(), 'Passwords must match')]");
    By REGISTER_BTN_LOCATOR = By.xpath("//button/following-sibling::a[contains(@href, '/registration')]");
    By HEADER_LOCATOR = By.xpath("//div/h1[contains(text(), 'Registration')]");
    By fNAME_LOCATOR = By.xpath("//input[@name='firstName']");
    By lNAME_LOCATOR = By.xpath("//input[@name='lastName']");
    By DATE_OF_BIRTH_LOCATOR = By.xpath("//input[@name='dateOfBirth']");
}
