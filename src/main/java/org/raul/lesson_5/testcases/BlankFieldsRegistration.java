package org.raul.lesson_5.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/* Testcase ID : L016 */
public class BlankFieldsRegistration {
    WebDriver driver;

    public BlankFieldsRegistration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitElement;
    @FindBy(xpath = "(//div//span[text()='Required'])[1]")
    private WebElement nameErrorElement;
    @FindBy(xpath = "(//div//span[text()='Required'])[4]")
    private WebElement emailErrorElement;

    public void clickSubmit() {
        submitElement.click();
    }

    public boolean isErrorDisplayed() {
        return nameErrorElement.isDisplayed() && emailErrorElement.isDisplayed();
    }
}
