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

    public void loginSuccess(WebDriver driver, String url) {
        driver.get(url);

        driver.findElement(By.name("email")).sendKeys(getEmail());
        driver.findElement(By.name("password")).sendKeys(getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
