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
    private WebDriver driver;
    private WebDriverWait wait;

    private By fnameLocator = By.xpath("//*[@id='fname']");
    private By lnameLocator = By.xpath("//*[@id='lname']");
    private By submitLocator = By.xpath("/html/body/form/input[3]");
    private By frameLocator = By.xpath("//iframe[@id='iframeResult']");
    private By noteLocator = By.xpath("//div[@class='w3-panel w3-pale-yellow w3-leftbar w3-border-yellow']/p");

    private String fName;
    private String lName;

    public W3FormFiller(WebDriver driver, String fName, String lName) {
        this.driver = driver;
        this.fName = fName;
        this.lName = lName;

        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    public void inputName() {
        WebElement iframe = driver.findElement(frameLocator);
        driver.switchTo().frame(iframe);

        WebElement nameElement = driver.findElement(fnameLocator);
        nameElement.clear();
        nameElement.sendKeys(this.fName);
    }

    public void inputLastName() {
        WebElement lastName = driver.findElement(lnameLocator);
        lastName.clear();
        lastName.sendKeys(this.lName);
    }

    public void clickSubmit() {
        driver.findElement(submitLocator).click();
    }

    public String retrieveNoteText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(noteLocator));
        return driver.findElement(noteLocator).getText();
    }

    public void switchToW3SchoolPage() {
        SwitchTab.switchBetweenTabs(driver, "W3Schools");
    }
}
