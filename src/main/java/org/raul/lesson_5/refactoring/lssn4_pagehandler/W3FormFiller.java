package org.raul.lesson_5.refactoring.lssn4_pagehandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.raul.utils.SwitchTab;

import java.time.Duration;

public class W3FormFiller {
    private WebDriver driver;

    public W3FormFiller(WebDriver driver) {
        this.driver = driver;
    }

    public String fillInForm(String fname, String lname) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        SwitchTab switchTab = new SwitchTab(driver);
        switchTab.switchBetweenTabs("W3Schools");

        By noteLocator = By.xpath("//div[@class='w3-panel w3-pale-yellow w3-leftbar w3-border-yellow']/p");
        By fnameLocator = By.xpath("//*[@id='fname']");
        By lnameLocator = By.xpath("//*[@id='lname']");
        By submitLocator = By.xpath("/html/body/form/input[3]");
        By frameLocator = By.xpath("//iframe[@id='iframeResult']");

        WebElement iframe = driver.findElement(frameLocator);
        driver.switchTo().frame(iframe);

        WebElement name = driver.findElement(fnameLocator);
        name.clear();
        name.sendKeys(fname);

        WebElement surname = driver.findElement(lnameLocator);
        surname.clear();
        surname.sendKeys(lname);

        driver.findElement(submitLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(noteLocator));

        return driver.findElement(noteLocator).getText();
    }
}
