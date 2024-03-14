package org.raul.lesson_5.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* Testcase ID: L020 */
public class InvalidEmailLogin extends LoginProcessor {
    private WebDriver driver;

    private By errorLocator = By.xpath("//span[contains(text(), 'is not valid')]");

    public InvalidEmailLogin(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(errorLocator).isDisplayed();
    }
}
