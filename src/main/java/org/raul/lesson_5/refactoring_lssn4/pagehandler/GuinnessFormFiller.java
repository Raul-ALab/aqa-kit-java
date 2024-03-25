package org.raul.lesson_5.refactoring_lssn4.pagehandler;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.raul.utils.SwitchTab;

import java.time.Duration;

/*
 * 1. Добавьте аллюр-репортинг к нашим тестам: своему проекту.
 *
 * Переключиться на окно, в котором открыта следующая ссылка:
 *   https://www.guinnessworldrecords.com/account/register?
 * В данном окне заполнить все поля соответствующей информацией. В полях
 * пароля и подтверждения пароля ввести различные произвольные пароли для
 * того, чтобы появилось уведомление об несоответствии данных паролей.
 * Вывести данное сообщение в консоль.
 * */
public class GuinnessFormFiller {
    private WebDriver driver;
    private WebDriverWait wait;

    private By fnameLocator = By.id("LastName");
    private By lnameLocator = By.id("FirstName");
    private By emailLocator = By.id("EmailAddress");
    private By confirmEmailLocator = By.id("ConfirmEmailAddress");
    private By dayLocator = By.id("DateOfBirthDay");
    private By monthLocator = By.id("DateOfBirthMonth");
    private By yearLocator = By.id("DateOfBirthYear");
    private By countryLocator = By.id("Country");
    private By stateLocator = By.id("State");
    private By passwordLocator = By.id("Password");
    private By confirmPasswordLocator = By.id("ConfirmPassword");
    private By bodyLocator = By.xpath("//body");
    private By clickAroundLocator = By.xpath("//label[contains(text(), 'Confirm password')]");
    private By errorLocator = By.xpath("//span[@class='field-validation-error']//span[@for='ConfirmPassword']");


    public GuinnessFormFiller(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    @Step("Enter first name: {name}")
    public void inputName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bodyLocator));
        driver.findElement(fnameLocator).sendKeys(name);
    }

    @Step("Enter last name: {lastName}")
    public void inputLastName(String lastName) {
        driver.findElement(lnameLocator).sendKeys(lastName);
    }

    @Step("Enter email: {email}")
    public void inputEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
    }

    @Step("Confirm email: {repeatEmail}")
    public void inputConfirmEmail(String repeatEmail) {
        driver.findElement(confirmEmailLocator).sendKeys(repeatEmail);
    }

    @Step("Enter the day of birthdate: {day}")
    public void inputDayOfBirthday(int day) {
        driver.findElement(dayLocator).sendKeys(String.valueOf(day));
    }

    @Step("Enter the month of birthdate: {month}")
    public void inputMonthOfBirthday(int month) {
        driver.findElement(monthLocator).sendKeys(String.valueOf(month));
    }

    @Step("Enter the year of birthdate: {year}")
    public void inputYearOfBirthday(int year) {
        driver.findElement(yearLocator).sendKeys(String.valueOf(year));
    }

    @Step("Enter country: {countryName}")
    public void inputRegion(String countryName) {
        Select countryDropdown = new Select(driver.findElement(countryLocator));
        countryDropdown.selectByVisibleText(countryName);

        wait.until(ExpectedConditions.textToBePresentInElementLocated(countryLocator, countryName));
    }

    @Step("Enter state: {state}")
    public void inputState(String state) {
        driver.findElement(stateLocator).sendKeys(state);
    }

    @Step("Enter password: {password}")
    public String inputPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return driver.findElement(passwordLocator).getAttribute("value");
    }

    @Step("Enter wrong value to confirm password: {repeatPassword}")
    public String inputConfirmPassword(String repeatPassword) {
        driver.findElement(confirmPasswordLocator).sendKeys(repeatPassword);
        return driver.findElement(confirmPasswordLocator).getAttribute("value");
    }

    @Step("Retrieve password mismatch error")
    public String retrieveErrorMessage() {
        driver.findElement(clickAroundLocator).click();

        String errText = "'Confirm password' and 'Password' do not match.";
        wait.until(ExpectedConditions.textToBePresentInElementLocated(errorLocator, errText));

        return driver.findElement(errorLocator).getText();
    }

    @Step("Switch to Guinness page")
    public void switchToGuinnessPage() {
        SwitchTab.switchBetweenTabs(driver, "Guinness");
    }
}
