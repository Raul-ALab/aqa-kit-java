package org.raul.lesson_4.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SwitchTab {
    private WebDriver driver;

    public SwitchTab(WebDriver driver) {
        this.driver = driver;
    }

    public void switchBetweenTabs(String titleKeyword) {
        List<String> windowHandles = new ArrayList(driver.getWindowHandles());

        for (String tab : windowHandles) {
            driver.switchTo().window(tab);
            if (driver.getTitle().contains(titleKeyword)) {
                break;
            }
        }
    }
}
