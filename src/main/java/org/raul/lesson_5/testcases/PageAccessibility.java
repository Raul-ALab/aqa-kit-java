package org.raul.lesson_5.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/* Testcase ID : L015 */
public class PageAccessibility {
    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    private By nameLocator = By.xpath("//input[@placeholder='Fitst Name']");
    private By signInLocator = By.xpath("//a[contains(text(), 'Sing in')]");

    public PageAccessibility(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public boolean navigateForward() {
        WebElement startPoint = wait.until(ExpectedConditions.visibilityOfElementLocated(nameLocator));
        WebElement destinationPoint = driver.findElement(signInLocator);

        actions.moveToElement(startPoint).build().perform();

        while (!destinationPoint.equals(driver.switchTo().activeElement())) {
            actions
                    .sendKeys(Keys.TAB)
                    .build().perform();
        }
        boolean isReachedToDestination = destinationPoint.equals(driver.switchTo().activeElement());

        return isReachedToDestination;
    }

    public boolean navigateBackward() {
        WebElement startPoint = wait.until(ExpectedConditions.visibilityOfElementLocated(signInLocator));
        WebElement destinationPoint = driver.findElement(nameLocator);

        actions.moveToElement(startPoint).build().perform();

        while (!destinationPoint.equals(driver.switchTo().activeElement())) {
            actions
                    .sendKeys(Keys.chord(Keys.SHIFT, Keys.TAB))
                    .build().perform();
        }
        boolean isReachedToDestination = destinationPoint.equals(driver.switchTo().activeElement());

        return isReachedToDestination;
    }
}
