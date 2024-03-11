package org.raul.utils;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

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
