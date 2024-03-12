package org.raul.lesson_5.refactoring_lssn4.pagehandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.raul.utils.SwitchTab;

import java.time.Duration;

/*
 * Refactoring:
 * В открытом окне заполнить поля своим именем и фамилией и нажать кнопку ‘Submit’.
 * После вывести в консоль текст данного элемента -> Note
 * */
public class W3FormFiller {
    By fnameLocator = By.xpath("//*[@id='fname']");
    By lnameLocator = By.xpath("//*[@id='lname']");
    By submitLocator = By.xpath("/html/body/form/input[3]");
    By frameLocator = By.xpath("//iframe[@id='iframeResult']");
    By noteLocator = By.xpath("//div[@class='w3-panel w3-pale-yellow w3-leftbar w3-border-yellow']/p");
    private WebDriver driver;
    private WebDriverWait wait;


    public W3FormFiller(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    public void inputName(String name) {
        switchToW3SchoolPage();
        WebElement iframe = driver.findElement(frameLocator);
        driver.switchTo().frame(iframe);

        WebElement nameElement = driver.findElement(fnameLocator);
        nameElement.clear();
        nameElement.sendKeys(name);
    }

    public void inputLastName(String lName) {
        WebElement lastName = driver.findElement(lnameLocator);
        lastName.clear();
        lastName.sendKeys(lName);
    }

    public void clickSubmit() {
        driver.findElement(submitLocator).click();
    }

    public String retrieveNoteText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(noteLocator));
        return driver.findElement(noteLocator).getText();
    }

    private void switchToW3SchoolPage() {
        SwitchTab.switchBetweenTabs(driver, "W3Schools");
    }
}
