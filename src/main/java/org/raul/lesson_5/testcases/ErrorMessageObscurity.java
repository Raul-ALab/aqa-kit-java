package org.raul.lesson_5.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* Testcase ID: L021 */
public class ErrorMessageObscurity extends LoginProcessor {
    private WebDriver driver;

    private By errorLocator = By.xpath("//span[contains(text(), 'not valid')]");

    public ErrorMessageObscurity(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String invalidEmailAttempt(String invalidEmail, String correctPasswor) {
        login(invalidEmail, correctPasswor);
        return driver.findElement(errorLocator).getText();
    }

    public String invalidPasswordAttempt(String correctEmail, String wrongPasswor) {
        login(correctEmail, wrongPasswor);
        return driver.findElement(errorLocator).getText();
    }
}
