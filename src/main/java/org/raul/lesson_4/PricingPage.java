package org.raul.lesson_4;

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
    }

    public boolean isCostEstimationPageUrl() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlContains("pricing"));

        return driver.getCurrentUrl().equals("https://andersenlab.com/pricing");
    }

    public String checkCostEstimationPageHeader() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.titleContains("Cost"));

        By headerLocator = By.xpath("//section[@id='calculator']/div"
                + "/h2[@class='Title-module--title--e41b8 "
                + "Title-module--h2--ff335 Title-module--black--54d0b']");

        return driver.findElement(headerLocator).getText();
    }

    public void clickPricingButton() {
        By pricingBtnLocator = By.xpath("//a[contains(@class, 'Button-module--button--094fe')]");

        driver.findElement(pricingBtnLocator).click();
    }
}
