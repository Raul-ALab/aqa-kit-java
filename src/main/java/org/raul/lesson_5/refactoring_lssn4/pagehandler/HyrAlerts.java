package org.raul.lesson_5.refactoring_lssn4.pagehandler;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.raul.utils.SwitchTab;

import java.time.Duration;

/*
 * Refactoring:
 * Переключиться на окно, в котором открыта следующая ссылка:
 *  https://www.hyrtutorials.com/p/alertsdemo.html
 * Нажать поочередно на кнопки.
 * */
public class HyrFormFiller {
    private WebDriver driver;
    private WebDriverWait wait;
    private Alert alert;

    private By outputLocator = By.id("output");
    private By alertBtnLocator = By.id("alertBox");
    private By confirmBtnLocator = By.id("confirmBox");
    private By promptBtnLocator = By.id("promptBox");
    private By bodyLocator = By.xpath("//body");

    public HyrFormFiller(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    /* После нажатия на первую кнопку нажать “Ok” на модальном окне и
    вывести в консоль сообщение в модуле “Popup box output”.*/
    public String clickAlertBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bodyLocator));
        wait.until(ExpectedConditions.elementToBeClickable(alertBtnLocator)).click();

        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alert.accept();
        return retrieveActionStatusNotes();
    }

    /* После нажатия на вторую кнопку нажать “Cancel” на модальном окне и
    вывести в консоль сообщение в модуле “Popup box output”.*/
    public String clickConfirmBtn() {
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtnLocator)).click();

        wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        return retrieveActionStatusNotes();
    }

    /* После нажатия на третью кнопку, ввести текст “Final step of this task” в
    модальном окне и нажать “Ok”. Вывести в консоль сообщение в модуле “Popup box output”*/
    public String clickPromptBtn(String text) {
        driver.switchTo().defaultContent();
        escapeAndScrollToBypassBottomFlyer();
        wait.until(ExpectedConditions.elementToBeClickable(promptBtnLocator)).click();

        wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        alert.accept();
        return retrieveActionStatusNotes();
    }

    private String retrieveActionStatusNotes() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(outputLocator)).getText();
    }

    private void escapeAndScrollToBypassBottomFlyer() {
        Actions actions = new Actions(driver);
        actions
                .sendKeys(Keys.ESCAPE)
                .scrollByAmount(0, 400)
                .build().perform();
    }

    public void switchToAlertsPage() {
        SwitchTab.switchBetweenTabs(driver, "AlertsDemo");
    }
}
