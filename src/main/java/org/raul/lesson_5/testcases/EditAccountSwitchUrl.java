package org.raul.lesson_5.testcases;

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

    public boolean clickEditAccount() {
        driver.findElement(editLocator).click();
        return driver.getCurrentUrl().contains("editAccount");
    }
}
