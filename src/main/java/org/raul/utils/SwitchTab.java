package org.raul.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SwitchTab {

    @Step("Check the title and if found, switch to it.")
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
