package org.raul.utils;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SwitchTab {
    private static WebDriver driver;

    public static void switchBetweenTabs(WebDriver driver, String titleKeyword) {
        List<String> windowHandles = new ArrayList(driver.getWindowHandles());

        for (String tab : windowHandles) {
            driver.switchTo().window(tab);
            if (driver.getTitle().contains(titleKeyword)) {
                break;
            }
        }
    }
}
