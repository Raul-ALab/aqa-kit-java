package org.raul.main;

import org.openqa.selenium.WebDriver;
import org.raul.lesson_4.pagehandler.PageOperations;
import org.raul.lesson_4.pagehandler.W3FormFiller;
import org.raul.utils.DriverSetUp;

public class DriverClass {
    public static void main( String[] args ) {
        WebDriver driver = DriverSetUp.setUpChromeDriver();

        PageOperations pageOpts = new PageOperations(driver);
        W3FormFiller w3Form = new W3FormFiller();


        String searchUrl1 = "https://www.guinnessworldrecords.com/account/register?";
        String searchUrl2 = "https://www.hyrtutorials.com/p/alertsdemo.html";
        String searchUrl3 = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit";


        driver.get("https://www.google.com/search");
        pageOpts.searchGuinnessByUrl(searchUrl1);
        pageOpts.searchHyrByUrl(searchUrl2);
        pageOpts.searchW3ByUrl(searchUrl3);

        w3Form.fillInForm(driver, "Raul", "Gurbanli");

    }

}
