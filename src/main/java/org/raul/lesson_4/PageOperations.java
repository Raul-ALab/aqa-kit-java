package org.raul.lesson_4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;


public class PageOperations {
    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    public PageOperations(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void searchExecutor(String url1, String url2, String url3) {

        By searchAreaLocator = By.xpath("//textarea[@id='APjFqb']");
        By guinnessLocator = By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]");
        By clearIconLocator = By.xpath("//span[@class='ExCKkf z1asCe rzyADb']");
        By hyrLocator = By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]");

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchAreaLocator));
        WebElement searchField = driver.findElement(searchAreaLocator);
        actions
                .moveToElement(searchField)
                .sendKeys(url1)
                .sendKeys(Keys.ENTER)
                .build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(guinnessLocator));
        WebElement searchResultGuinness = driver.findElement(guinnessLocator);
        actions
                .moveToElement(searchResultGuinness)
                .keyDown(Keys.CONTROL)
                .click(searchResultGuinness)
                .keyUp(Keys.CONTROL)
                .build().perform();

        driver.findElement(clearIconLocator).click();
        actions
                .sendKeys(url2)
                .sendKeys(Keys.ENTER)
                .build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(hyrLocator));
        WebElement searchResultHyr = driver.findElement(hyrLocator);
        actions
                .moveToElement(searchResultHyr)
                .keyDown(Keys.CONTROL)
                .click(searchResultHyr)
                .keyUp(Keys.CONTROL)
                .build().perform();

        driver.navigate().to(url3);
    }
}
