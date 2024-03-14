package org.raul.lesson_4.pagehandler;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.raul.lesson_4.utils.SwitchTab;

import java.time.Duration;

@Getter
@Setter
public class GuinnessFormFiller {
    private String fname;
    private String lname;
    private String email;
    private String confirmEmail;
    private String password;
    private String confimrPassword;
    private int day;
    private int month;
    private int year;
    private String countryCode;
    private String state;

    @Setter(AccessLevel.PRIVATE)
    private WebDriver driver;

    public GuinnessFormFiller(WebDriver driver) {
        this.driver = driver;
    }


    public String fillInForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        SwitchTab switchTab = new SwitchTab(driver);
        switchTab.switchBetweenTabs("Guinness");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        WebElement fnameElement = driver.findElement(By.id("LastName"));
        WebElement lnameElement = driver.findElement(By.id("FirstName"));
        WebElement emailElement = driver.findElement(By.id("EmailAddress"));
        WebElement confirmEmailElement = driver.findElement(By.id("ConfirmEmailAddress"));
        WebElement dayElement = driver.findElement(By.id("DateOfBirthDay"));
        WebElement monthElement = driver.findElement(By.id("DateOfBirthMonth"));
        WebElement yearElement = driver.findElement(By.id("DateOfBirthYear"));
        WebElement countryElement = driver.findElement(By.id("Country"));
        WebElement stateElement = driver.findElement(By.id("State"));

        WebElement passwordElement = driver.findElement(By.id("Password"));
        WebElement confirmPasswordElement = driver.findElement(By.id("ConfirmPassword"));
        Select countryDropdown = new Select(countryElement);

        fnameElement.sendKeys(getFname());
        lnameElement.sendKeys(getLname());
        dayElement.sendKeys(String.valueOf(getDay()));
        monthElement.sendKeys(String.valueOf(getMonth()));
        yearElement.sendKeys(String.valueOf(getYear()));
        countryDropdown.selectByValue(getCountryCode());
        stateElement.sendKeys(getState());
        emailElement.sendKeys(getEmail());
        confirmEmailElement.sendKeys(getConfirmEmail());

        passwordElement.sendKeys(password);
        confirmPasswordElement.sendKeys(confimrPassword);


        WebElement clickForCheck = driver.findElement(By.xpath("//div[@class='body-copy block block-8-12 block-last']"));
        clickForCheck.click();

        By errorLocator = By.xpath("//span[@class='field-validation-error']//span[@for='ConfirmPassword']");
        WebElement passwordMismatchElement = driver.findElement(errorLocator);
        String errText = "'Confirm password' and 'Password' do not match.";
        wait.until(ExpectedConditions.textToBePresentInElement(passwordMismatchElement, errText));

        return passwordMismatchElement.getText();
    }
}
