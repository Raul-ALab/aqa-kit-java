package org.raul.lesson_2.testcases;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
 * 1)Автоматизируйте по два тест-кейса из каждого модуля, которые
 * вы писали для предыдущего домашнего задания.
 *
 * Рауль: Редактирoвание страницы учетной записи не работало в моем
 * случае, и я завершил 15 тест-кейсов только с 2 модулями. Поэтому
 * я разделил 6 методов между двумя модулями, для которых я написал
 * тест-кейсы.
 * */

@Getter(AccessLevel.PRIVATE)
@Setter
public class RegistrationFlow {
    private String name;
    private String surname;
    private String birthdate;
    private String email;
    private String password;
    private String confirmPassword;

    // Test Case ID : L01
    public void registrationPasswordMismatch(WebDriver driver, String url) {
        driver.get(url);

        driver.findElement(By.cssSelector("input[placeholder='Fitst Name']")).sendKeys(getName());
        driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys(getSurname());
        driver.findElement(By.name("dateOfBirth")).sendKeys(getBirthdate());

        driver.findElement(By.name("email")).click(); // This is to dismiss calendar after date input
        driver.findElement(By.name("email")).sendKeys(getEmail());

        driver.findElement(By.name("password")).sendKeys(getPassword());
        driver.findElement(By.name("passwordConfirmation")).sendKeys(getConfirmPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    // Test Case ID : L06
    public void registrationEmailFormat(WebDriver driver, String url) {
        driver.get(url);

        driver.findElement(By.cssSelector("input[placeholder='Fitst Name']")).sendKeys(getName());
        driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys(getSurname());
        driver.findElement(By.name("dateOfBirth")).sendKeys(getBirthdate());

        driver.findElement(By.name("email")).click(); // This is to dismiss calendar after date input
        driver.findElement(By.name("email")).sendKeys(getEmail());

        driver.findElement(By.name("password")).sendKeys(getPassword());
        driver.findElement(By.name("passwordConfirmation")).sendKeys(getConfirmPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    // Test Case ID : L08
    public void registrationSuccess(WebDriver driver, String url) {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

        driver.findElement(By.cssSelector("input[placeholder='Fitst Name']")).sendKeys(getName());
        driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys(getSurname());
        driver.findElement(By.name("dateOfBirth")).sendKeys(getBirthdate());

        driver.findElement(By.name("email")).click(); // This is to dismiss calendar after date input
        driver.findElement(By.name("email")).sendKeys(getEmail());

        driver.findElement(By.name("password")).sendKeys(getPassword());
        driver.findElement(By.name("passwordConfirmation")).sendKeys(getConfirmPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//p[text()='Logout']"))).click();
        driver.findElement(By.xpath("//button[@style='background: red;' "
                + "and @label='Yes']")).click();

        /* Wait for Sign In page and sign back with new credentials for
        double-checking the account*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//*[text()='Sign In']")));
        driver.findElement(By.name("email")).sendKeys(getEmail());
        driver.findElement(By.name("password")).sendKeys(getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
