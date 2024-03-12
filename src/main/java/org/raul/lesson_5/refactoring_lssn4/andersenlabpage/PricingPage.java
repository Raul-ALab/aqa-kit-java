package org.raul.lesson_5.refactoring_lssn4.andersenlabpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public PricingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public boolean isCostEstimationPageUrl() {
        wait.until(ExpectedConditions.urlContains("pricing"));
        return driver.getCurrentUrl().equals("https://andersenlab.com/pricing");
    }

    public String checkCostEstimationPageHeader() {
        By headerLocator = By.xpath("//section[@id='calculator']/div"
                + "/h2[@class='Title-module--title--e41b8 "
                + "Title-module--h2--ff335 Title-module--black--54d0b']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
        return driver.findElement(headerLocator).getText();
    }

    public void clickPricingButton() {
        By pricingBtnLocator = By.xpath("//a[contains(@class, 'Button-module--button--094fe')]");

        wait.until(ExpectedConditions.elementToBeClickable(pricingBtnLocator));
        driver.findElement(pricingBtnLocator).click();
    }
}
