package org.raul.main;

import org.openqa.selenium.WebDriver;
import org.raul.lesson_4.PageOperations;
import org.raul.lesson_4.PricingPage;
import org.raul.utils.DriverSetUp;

public class DriverClass {
    public static void main( String[] args ) {
        WebDriver driver = DriverSetUp.setUpChromeDriver();

        PageOperations pageOpts = new PageOperations(driver);

        String searchUrl1 = "https://www.guinnessworldrecords.com/account/register?";
        String searchUrl2 = "https://www.hyrtutorials.com/p/alertsdemo.html";
        String searchUrl3 = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit";


        driver.get("https://www.google.com/search");

        pageOpts.searchExecutor(searchUrl1, searchUrl2, searchUrl3);

    }

}
