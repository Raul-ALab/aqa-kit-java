package org.raul.lesson_5.testcases;

import org.openqa.selenium.WebDriver;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/* Testcase ID : L015 */
public class PageAccessibilityTest {
    private final static String URL = "https://qa-course-01.andersenlab.com/registration";

    private WebDriver driver;
    private PageAccessibility accessibility;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.setUpChromeDriver();
        accessibility = new PageAccessibility(driver);
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verifyPageAccessibilityNavigateForwardViaKeyboard() {
        boolean isReachedToEndDestination = accessibility.navigateForward();
        Assert.assertTrue(isReachedToEndDestination, "Forward navigation is not possible via keyboard.");
    }

    @Test(dependsOnMethods = "verifyPageAccessibilityNavigateForwardViaKeyboard")
    public void verifyPageAccessibilityNavigateBackwardViaKeyboard() {
        boolean isReachedToTopDestination = accessibility.navigateBackward();
        Assert.assertTrue(isReachedToTopDestination, "Backward navigation is not possible via keyboard.");
    }
}
