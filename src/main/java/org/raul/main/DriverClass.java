package org.raul.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.raul.lesson_4.pagehandler.*;
import org.raul.utils.DriverSetUp;

public class DriverClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpChromeDriver();

        PageOperations pageOpts = new PageOperations(driver);

        String baseUrl = "https://www.google.com/search";
        String searchUrl1 = "https://www.guinnessworldrecords.com/account/register?";
        String searchUrl2 = "https://www.hyrtutorials.com/p/alertsdemo.html";
        String searchUrl3 = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit";

//        driver.get(baseUrl);
//        pageOpts.searchGuinnessByUrl(searchUrl1);
//        pageOpts.searchHyrByUrl(searchUrl2);
//        pageOpts.searchW3ByUrl(searchUrl3);
//
//        W3FormFiller w3Form = new W3FormFiller(driver);
//        System.out.println(w3Form.fillInForm("Raul", "Gurbanli"));
//
//        GuinnessFormFiller guinnessForm = new GuinnessFormFiller(driver);
//        guinnessForm.setFname("Raul");
//        guinnessForm.setLname("Gurbanli");
//        guinnessForm.setEmail("anyemail@example.uk");
//        guinnessForm.setConfirmEmail("anyemail@example.uk");
//        guinnessForm.setPassword("a1234567");
//        guinnessForm.setConfimrPassword("1234567abc");
//        guinnessForm.setDay(7);
//        guinnessForm.setMonth(11);
//        guinnessForm.setYear(1991);
//        guinnessForm.setCountryCode("AZ");
//        guinnessForm.setState("Absheron");
//
//        String errText = guinnessForm.fillInForm();
//        System.out.println(errText);
//
//        HyrFormFiller hyrFormFiller = new HyrFormFiller(driver);
//        hyrFormFiller.fillInForm();
//    }

        String urlRegister = "https://qa-course-01.andersenlab.com/registration";
        PageRegistration pageRegistration = new PageRegistration();
        pageRegistration.setName("Alina");
        pageRegistration.setSurname("Park");
        pageRegistration.setEmail("apark@example.com");
        pageRegistration.setBirthdate("02/09/1999");
        pageRegistration.setPassword("a.park123");
        pageRegistration.setConfirmPassword("a.park123");

        pageRegistration.registrationSuccess(driver, urlRegister);
    }

}
