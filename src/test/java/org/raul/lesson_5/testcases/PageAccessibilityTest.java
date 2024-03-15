package org.raul.lesson_5.testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.raul.listener.AllureTestListener;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
* 1. Добавьте аллюр-репортинг к нашим тестам: своему проекту.
* 2. Добавьте браузерные логи, если это потребуется.
*
* Testcase ID : L015
* */

@Listeners({AllureTestListener.class})
@Epic("Test Cases from lesson 9")
@Feature("Registration Page Testing")
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
    @Description("Test Case L015 : Registration page accessibility.")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("User is able to navigate forward with keyboard via Tab button")
    @Link(name = "Test Cases file testcases(rev.1)", url = "src/test/resources/testcases(rev.1).xlsx")
    public void verifyPageAccessibilityNavigateForwardViaKeyboard() {
        boolean isReachedToEndDestination = accessibility.navigateForward();
        Assert.assertTrue(isReachedToEndDestination, "Forward navigation is not possible via keyboard.");
    }

    @Test(dependsOnMethods = "verifyPageAccessibilityNavigateForwardViaKeyboard")
    @Description("Test Case L015 : Registration page accessibility.")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("User is able to navigate backward with keyboard via Shift+Tab buttons")
    @Link(name = "Test Cases file testcases(rev.1)", url = "src/test/resources/testcases(rev.1).xlsx")
    public void verifyPageAccessibilityNavigateBackwardViaKeyboard() {
        boolean isReachedToTopDestination = accessibility.navigateBackward();
        Assert.assertTrue(isReachedToTopDestination, "Backward navigation is not possible via keyboard.");
    }
}
