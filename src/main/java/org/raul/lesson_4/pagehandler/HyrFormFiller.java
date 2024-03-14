package org.raul.lesson_4.pagehandler;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.raul.lesson_4.utils.SwitchTab;

import java.time.Duration;

/*
* Переключиться на окно, в котором открыта следующая
* ссылка: https://www.hyrtutorials.com/p/alertsdemo.html
* Нажать поочередно на кнопки...
* */
public class HyrFormFiller {

    private WebDriver driver;

    public HyrFormFiller(WebDriver driver) {
        this.driver = driver;
    }

    public String fillInForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        SwitchTab switchTab = new SwitchTab(driver);
        switchTab.switchBetweenTabs("AlertsDemo");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        WebElement outputElement = driver.findElement(By.id("output"));

        // После нажатия на первую кнопку нажать “Ok” на модальном окне и
        // вывести в консоль сообщение в модуле “Popup box output”.
        WebElement alertBtnElement = driver.findElement(By.id("alertBox"));
        alertBtnElement.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String text1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("output"))).getText();

        // После нажатия на вторую кнопку нажать “Cancel” на модальном окне и
        // вывести в консоль сообщение в модуле “Popup box output”.
        driver.switchTo().defaultContent();
        WebElement confirmBtnElement = driver.findElement(By.id("confirmBox"));
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtnElement)).click();

        wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        String text2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("output"))).getText();

        // После нажатия на третью кнопку, ввести текст “ Final step of this task” в
        // модальном окне и нажать “Ok”. Вывести в консоль сообщение в модуле “Popup box output”
        driver.switchTo().defaultContent();
        WebElement promptBtnElement = driver.findElement(By.id("promptBox"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", promptBtnElement);
        wait.until(ExpectedConditions.elementToBeClickable(promptBtnElement));
        promptBtnElement.click();

        wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Final step of this task");
        alert.accept();
        String text3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("output"))).getText();

        return text1 + "\n" + text2 + "\n" + text3;
    }
}
