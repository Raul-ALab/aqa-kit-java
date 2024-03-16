package org.raul.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/* Singleton design pattern */
public class DriverSetUp2 {
    private static WebDriver driver;

    @Step("Set up and start driver : Chrome")
    public static WebDriver startDriver() {
        driver = getInstance();
        return driver;
    }

    /* Initialisation if it hasn't already been initialised
     to assure the single instance of the driver. */
    private static WebDriver getInstance() {
        if (driver == null) {
            try {
                driver = setUpChromeDriver();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return driver;
    }

    private static WebDriver setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
//        options.addExtensions(new File("src/test/resources/extensions/AdBlock.crx"));

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        return driver;
    }
}
