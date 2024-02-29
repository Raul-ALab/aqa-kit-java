package org.raul.lesson_2.scripts;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.raul.lesson_2.utils.DriverSetUp;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 2)Написать программу, которая будет открывать пять
различных страниц в новых окнах. */
@Getter(AccessLevel.PRIVATE)
public class WindowHandler {
    private List<WebDriver> driverList;

    @Setter
    private String[] urlArr;

    public WindowHandler(int arrSize) {
        this.urlArr = new String[arrSize];
        this.driverList = new ArrayList<>();
    }

    /* 2.(a) Написать программу, которая будет открывать пять
    различных страниц в новых окнах...*/
    public void openUrls(int implicitWaitSec) {
        for (int i = 0; i < getUrlArr().length; i++) {
            WebDriver driver = DriverSetUp.setUpDriver();
            driverList.add(driver);
            driver.manage()
                    .timeouts()
                    .implicitlyWait(Duration.ofSeconds(implicitWaitSec));
            driver.get(getUrlArr()[i]);
        }
    }

    /* 2.(b)... Прописать цикл, который будет переключаться поочередно
    через все страницы, для каждой страницы выводить в консоль название
     и ссылку на эту страницу...*/
    public Map<String, String> getTitleAndUrl() {
        Map<String, String> titleUrlPair = new HashMap<>();
        for (WebDriver driver : getDriverList()) {
            titleUrlPair.put(driver.getCurrentUrl(), driver.getTitle());
        }
        return titleUrlPair;
    }

    /* 2.(c)... И будет закрывать ту страницу в названии которой есть слово "Zoo".*/
    public void closeSpecificWindow(String keyword) {
        for (WebDriver driver : getDriverList()) {
            if (driver.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                driver.quit();
                System.out.println("The window that contains the word '" + keyword
                        + "' is closed!");
                break;
            }
        }
    }

    public void quitDrivers() {
        for (WebDriver driver : getDriverList()) {
            driver.quit();
        }
    }
}
