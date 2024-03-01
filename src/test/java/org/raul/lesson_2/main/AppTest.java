package org.raul.lesson_2.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.raul.lesson_2.scripts.ElementComparison;
import org.raul.lesson_2.utils.DriverSetUp;

public class AppTest {
    public static void main(String[] args) {

        WebDriver driver = DriverSetUp.setUpDriver();
        String url = "http://www.automationpractice.pl/index.php";
        driver.get(url);

        WebElement elementA = driver.findElement(By.className("blockbestsellers"));
        WebElement elementB = driver.findElement(By.className("login"));

        ElementComparison location = new ElementComparison();
        location.compareElements(elementA, elementB);


/*        String url1 = "http://www.automationpractice.pl/index.php";
        String url2 = "https://zoo.waw.pl/";
        String url3 = "https://www.w3schools.com/";
        String url4 = "https://www.clickspeedtester.com/click-counter/";
        String url5 = "https://andersenlab.com/";

        int arrSize = 5;
        String[] urlArr = {url1, url2, url3, url4, url5};

        WindowHandler windows = new WindowHandler(arrSize);
        windows.setUrlArr(urlArr);
        windows.openUrls(1);

        for (Map.Entry<String, String> entry : windows.getTitleAndUrl().entrySet()) {
            System.out.println("Title: " + entry.getValue() + ", URL: " + entry.getKey());
        }

        windows.closeSpecificWindow("Zoo");*/

    }
}
