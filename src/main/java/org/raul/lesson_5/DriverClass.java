package org.raul.lesson_5;

import org.openqa.selenium.WebDriver;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.GuinnessFormFiller;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.HyrFormFiller;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.PageOperations;
import org.raul.lesson_5.refactoring_lssn4.pagehandler.W3FormFiller;
import org.raul.utils.DriverSetUp;

public class DriverClass {
    public static void main(String[] args) {
        String BASE_URL = "https://www.google.com/search";
        String URL_1 = "https://www.guinnessworldrecords.com/account/register?";
        String URL_2 = "https://www.hyrtutorials.com/p/alertsdemo.html";
        String URL_3 = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit";

        WebDriver driver = DriverSetUp.setUpChromeDriver();
        driver.get(BASE_URL);

        PageOperations page = new PageOperations(driver);
        page.searchGuinnessByUrl(URL_1);
        page.searchHyrByUrl(URL_2);
        page.searchW3ByUrl(URL_3);

        W3FormFiller w3FormFiller = new W3FormFiller(driver, "Raul", "Gurbanli");
        w3FormFiller.inputName();
        w3FormFiller.inputLastName();
        w3FormFiller.clickSubmit();
        System.out.println(w3FormFiller.retrieveNoteText());

        GuinnessFormFiller guinnessFormFiller = new GuinnessFormFiller(driver);
        guinnessFormFiller.inputName("Raul");
        guinnessFormFiller.inputLastName("Gurbanli");
        guinnessFormFiller.inputDayOfBirthday(7);
        guinnessFormFiller.inputMonthOfBirthday(11);
        guinnessFormFiller.inputYearOfBirthday(1990);
        guinnessFormFiller.inputRegion("Azerbaijan");
        guinnessFormFiller.inputState("Absheron");
        guinnessFormFiller.inputEmail("anyemail@example.uk");
        guinnessFormFiller.inputConfirmEmail("anyemail@example.uk");
        guinnessFormFiller.inputPassword("a1234567");
        guinnessFormFiller.inputConfirmPassword("a12345676");
        System.out.println(guinnessFormFiller.retrieveErrorMessage());


        HyrFormFiller hyr = new HyrFormFiller(driver);

        System.out.println(hyr.clickAlertBtn());
        System.out.println(hyr.clickConfirmBtn());
        System.out.println(hyr.clickPromptBtn("Final step of this task"));
    }
}
