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
public class LoginFlow {
    private String email;
    private String password;
    private String wrongPassword;

    public void loginSuccess(WebDriver driver, String url) {
        driver.get(url);

        driver.findElement(By.name("email")).sendKeys(getEmail());
        driver.findElement(By.name("password")).sendKeys(getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void backButtonAfterLogout(WebDriver driver, String url) {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

        driver.findElement(By.name("email")).sendKeys(getEmail());
        driver.findElement(By.name("password")).sendKeys(getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//p[text()='Logout']"))).click();
        driver.findElement(By.xpath("//button[@style='background: red;' "
                + "and @label='Yes']")).click();

        driver.navigate().back();
    }

    public String invalidLoginCredentials(WebDriver driver, String url) {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

        driver.findElement(By.name("email")).sendKeys(getEmail());
        driver.findElement(By.name("password")).sendKeys(getWrongPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String error = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//span[text()='Email or password is not valid']"))).getText();
        return error;
    }
}
