package org.raul.lesson_5.refactoring_lssn4.andersenlabpage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.raul.utils.HandleCookies;

import java.time.Duration;

/*
 * Refactoring:
 * 1. Напишите 2 тест кейса на проверку каких либо визуальных элементов сайта
 * https://andersenlab.com/. (Например отображение кнопок Skype, WatsApp или
 * на переход на страницу проекта Verivox. А лучше придумайте что-нибудь свое)).
 *
 * L02: testcases_ lssn12.xlsx
 * */
public class VerivoxPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By pageNameLocator = By.xpath("//p[text()='Projects']/following-sibling::a[text()='Verivox']");
    private By headerLocator = By.xpath("//*[text()='A FinTech Portal to Compare Utility Payment Rates']");
    private By cookieLocator = By.xpath("//section/following-sibling::div//div//button[contains(text(), 'Accept')]");


    public VerivoxPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Step("Navigate to and click on the Verivox menu")
    public WebElement navigateToVerivox() {
        wait.until(ExpectedConditions.elementToBeClickable(pageNameLocator));
        driver.findElement(pageNameLocator).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
        return driver.findElement(headerLocator);
    }

    @Step("Accept cookies if present")
    public void acceptCookies() {
        HandleCookies.acceptCookiesIfPresent(driver, cookieLocator);
    }
}
