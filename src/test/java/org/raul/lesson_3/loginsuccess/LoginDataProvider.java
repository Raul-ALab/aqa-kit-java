package org.raul.lesson_3.loginsuccess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.raul.lesson_3.utils.DriverSetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

/*
 * Task 4: Заранее создать трех пользователей для нашего сайта. Написать тест
 * используя @DataProvider который будет проверять логин этих трех
 * пользователей.
 * */
public class LoginDataProvider {

    @Test(dataProvider = "credentials")
    public void loginSuccessTest(String email, String password) {
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


    @DataProvider(name = "credentials")
    public Object[][] loginData() {
        return new Object[][]{
                {"mboone@example.com", "boone123"},
                {"spader@example.com", "js123456"},
                {"laura@example.com", "ls123456"}
        };
    }
}
