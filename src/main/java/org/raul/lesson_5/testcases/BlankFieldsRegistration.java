package org.raul.lesson_5.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/* Testcase ID : L016 */
public class BlankFieldsRegistration {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitElement;
    @FindBy(xpath = "(//div//span[text()='Required'])[1]")
    private WebElement nameErrorElement;
    @FindBy(xpath = "(//div//span[text()='Required'])[4]")
    private WebElement emailErrorElement;

    public BlankFieldsRegistration(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    public void clickSubmit() {
        submitElement.click();
    }

    public boolean isErrorDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(nameErrorElement)).isDisplayed();
        return nameErrorElement.isDisplayed() && emailErrorElement.isDisplayed();
    }
}
