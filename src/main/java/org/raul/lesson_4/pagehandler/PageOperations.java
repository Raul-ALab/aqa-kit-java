package org.raul.lesson_4.pagehandler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void searchGuinnessByUrl(String url) {
        By searchAreaLocator = By.xpath("//textarea[@id='APjFqb']");
        By guinnessLocator = By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]");

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchAreaLocator));
        WebElement searchField = driver.findElement(searchAreaLocator);
        actions
                .moveToElement(searchField)
                .sendKeys(url)
                .sendKeys(Keys.ENTER)
                .build().perform();

        openInNewTab(guinnessLocator);
    }

    public void searchHyrByUrl(String url) {
        By hyrLocator = By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]");
        clearSearchField();
        actions
                .sendKeys(url)
                .sendKeys(Keys.ENTER)
                .build().perform();

        openInNewTab(hyrLocator);
    }

    public void searchW3ByUrl(String url) {
        driver.navigate().to(url);
    }

    private void openInNewTab(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement searchResult = driver.findElement(locator);
        actions
                .moveToElement(searchResult)
                .keyDown(Keys.CONTROL)
                .click(searchResult)
                .keyUp(Keys.CONTROL)
                .build().perform();
    }

    private void clearSearchField() {
        By clearIconLocator = By.xpath("//span[@class='ExCKkf z1asCe rzyADb']");
        driver.findElement(clearIconLocator).click();
    }
}
