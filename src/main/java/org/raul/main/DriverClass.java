package org.raul.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.raul.utils.DriverSetUp;

public class App {
    public static void main( String[] args ) {
        WebDriver driver = DriverSetUp.setUpChromeDriver();
        Actions actions = new Actions(driver);
    }
}
