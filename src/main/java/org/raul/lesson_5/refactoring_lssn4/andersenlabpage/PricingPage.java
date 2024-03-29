package org.raul.lesson_5.refactoring_lssn4.andersenlabpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
 * L01: testcases_ lssn12.xlsx
 * */
public class PricingPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By headerLocator = By.xpath("//section[@id='calculator']//h2[contains(text(), 'cost estimate')]");
    private By pricingBtnLocator = By.xpath("//div[contains(@class, 'Header')]/following-sibling::a[contains(text(), 'pricing')]");
    private By cookieLocator = By.xpath("//section/following-sibling::div//div//button[contains(text(), 'Accept')]");


    public PricingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public boolean isCostEstimationPageUrl() {
        wait.until(ExpectedConditions.urlContains("pricing"));
        return driver.getCurrentUrl().equals("https://andersenlab.com/pricing");
    }

    public String checkCostEstimationPageHeader() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
        return driver.findElement(headerLocator).getText();
    }

    public void clickPricingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(pricingBtnLocator));
        driver.findElement(pricingBtnLocator).click();
    }

    public void acceptCookies() {
        HandleCookies.acceptCookiesIfPresent(driver, cookieLocator);
    }
}
