package org.raul.lesson_6.refactoring_lssn4.pagehandler;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
 * 1. Добавьте аллюр-репортинг к нашим тестам: своему проекту.
 *
 * 2. Необходимо автоматизировать сценарий, который показан на видео
 * Сценарий для автоматизации Лекция 12.mp4 :
 *   1)Для этого открыть поиск гугл: https://www.google.com/search
 *   2) После ввести в поисковую строку следующую ссылку:
 *   https://www.guinnessworldrecords.com/account/register?
 * Открыть подходящую ссылку в новом окне, которая будет отображаться в результатах.
 *   3) После ввести в поисковую строку следующую ссылку:
 *   https://www.hyrtutorials.com/p/alertsdemo.html
 * Открыть подходящую ссылку в новом окне, которая будет отображаться в результатах.
 *   4) Открыть в активном окне следующую ссылку:
 *   https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit
 * */
public class PageOperations {
    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    private By searchAreaLocator = By.xpath("//textarea[@id='APjFqb']");
    private By guinnessLocator = By.xpath("//h3[contains(text(),'Create account')]/parent::a");
    private By hyrLocator = By.xpath("//h3[contains(text(),'AlertsDemo')]/parent::a");
    private By clearIconLocator = By.xpath("//div[@class='BKRPef']");


    public PageOperations(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Step("Search and open Guinness page in a new tab")
    public void searchGuinnessByUrl(String url) {
        executeSearch(url);
        openInNewTab(guinnessLocator);
    }

    @Step("Search and open HYR Alerts page in a new tab")
    public void searchHyrByUrl(String url) {
        clearSearchField();
        executeSearch(url);
        openInNewTab(hyrLocator);
    }

    @Step("Navigate to browser and open W3Schools page")
    public void searchW3ByUrl(String url) {
        driver.navigate().to(url);
    }

    @Step("Navigate to the search field and enter url to execute search")
    private void executeSearch(String url) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchAreaLocator));
        WebElement searchField = driver.findElement(searchAreaLocator);
        actions
                .moveToElement(searchField)
                .sendKeys(url)
                .sendKeys(Keys.ENTER)
                .build().perform();
    }

    @Step("Open the search result in a new tab")
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

    @Step("Clear search field prior to new search")
    private void clearSearchField() {
        driver.findElement(clearIconLocator).click();
    }
}
