package org.raul.lesson_5.testcases;

import io.qameta.allure.Step;
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

    @Step("Enter invalid email '{invalidEmail}' with a valid password: '{correctPassword}'")
    public String invalidEmailAttempt(String invalidEmail, String correctPasswor) {
        login(invalidEmail, correctPasswor);
        return driver.findElement(errorLocator).getText();
    }

    @Step("Enter valid email '{correctEmail}' with a wrong password: '{wrongPassword}'")
    public String invalidPasswordAttempt(String correctEmail, String wrongPasswor) {
        login(correctEmail, wrongPasswor);
        return driver.findElement(errorLocator).getText();
    }
}
