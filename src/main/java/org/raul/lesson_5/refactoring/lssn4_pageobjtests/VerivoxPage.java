package org.raul.lesson_5.refactoring.lssn4_pageobjtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerivoxPage {
    private WebDriver driver;

    public VerivoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement navigateToVerivox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        By pageNameLocator = By.xpath("//p[text()='Projects']/following-sibling::a[text()='Verivox']");
        By headerLocator = By.xpath("//*[text()='A FinTech Portal to Compare Utility Payment Rates']");

        wait.until(ExpectedConditions.elementToBeClickable(pageNameLocator));
        driver.findElement(pageNameLocator).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
        return driver.findElement(headerLocator);
    }
}
