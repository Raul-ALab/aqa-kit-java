package org.raul.lesson_2.main;

import org.raul.lesson_2.scripts.WindowHandler;

import java.util.Map;

public class AppTest {
    public static void main(String[] args) throws InterruptedException {

        String url1 = "http://www.automationpractice.pl/index.php";
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

        windows.closeSpecificWindow("Zoo");
//        windows.quitDrivers();


        /*        WebDriver driver = DriverSetUp.setUpDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://qa-course-01.andersenlab.com/login");
        System.out.println(driver.getCurrentUrl() + " title " + driver.getTitle());
        driver.findElement(By.name("email")).sendKeys("raul");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@class='mt-7 h-10 bg-[#feda00] rounded-3xl w-full opacity-60']")).click();
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        Thread.sleep(4000);
        driver.quit();*/
    }
}
