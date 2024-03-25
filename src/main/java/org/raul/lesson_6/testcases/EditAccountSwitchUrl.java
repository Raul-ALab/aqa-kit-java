package org.raul.lesson_6.testcases;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*Testcase ID: L018 */
public class EditAccountSwitchUrl extends LoginProcessor {
    private WebDriver driver;

    private By editLocator = By.xpath("//div//a[text()='Edit account']");

    public EditAccountSwitchUrl(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click 'Edit Account'")
    public boolean clickEditAccount() {
        driver.findElement(editLocator).click();
        return driver.getCurrentUrl().contains("editAccount");
    }
}
