package org.raul.lesson_3.loginsuccess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.raul.lesson_3.utils.DriverSetUp;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

/*
 * Task 5: Решить предыдущую задачу используя аннотацию @Parameters.
 * А также создать для работы с данным тестом дополнительный xml файл
 * testngParametersHome.xml.
 * */
public class LoginParameters {

    @Test
    @Parameters({"email", "password"})
    public void loginSuccessTestParameters(String email, String password) {
        WebDriver driver = DriverSetUp.setUpDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://qa-course-01.andersenlab.com/login");

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        By logoutLocator = By.xpath("//p[text()='Logout']");
        wait.until(ExpectedConditions.elementToBeClickable(logoutLocator));

        driver.quit();
    }
}
