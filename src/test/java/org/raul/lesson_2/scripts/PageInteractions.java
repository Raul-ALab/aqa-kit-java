package org.raul.lesson_2.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/* 4)Написать программу, которая повторит действия на
видео "Сценарий для автоматизации Лекция 10.mp4*/
public class PageInteractions {

    public void webAutoPractice(WebDriver driver, String url) {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

        driver.findElement(By.id("search_query_top")).sendKeys("Printed chiffon dress");
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();

        driver.findElement(By.id("list")).click();
        driver.findElement(By.xpath("//a[contains(@class, 'add_to_compare')]")).click();
        wait.until(ExpectedConditions.attributeToBe(By
                        .xpath("//input[contains(@class, 'compare_product_count')]"),
                "value", "1"));

        driver.findElement(By.xpath("//a[@title='Women']")).click();
        driver.findElement(By.id("search_query_top")).sendKeys("Faded Short");
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();

        driver.findElement(By.xpath("//a[contains(@class, 'add_to_compare')]")).click();
        wait.until(ExpectedConditions.attributeToBe(By
                        .xpath("//input[contains(@class, 'compare_product_count')]"),
                "value", "2"));

        driver.findElement(By.xpath("//span/strong[@class='total-compare-val']")).click();

//        driver.quit();
    }
}
