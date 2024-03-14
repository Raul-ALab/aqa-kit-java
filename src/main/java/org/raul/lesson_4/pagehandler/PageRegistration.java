package org.raul.lesson_4.pagehandler;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
@Setter
public class PageRegistration {
    private String name;
    private String surname;
    private String birthdate;
    private String email;
    private String password;
    private String confirmPassword;

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
    }
}
