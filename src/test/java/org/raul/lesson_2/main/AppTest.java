package org.raul.lesson_2.main;

import org.openqa.selenium.WebDriver;
import org.raul.lesson_2.utils.ObsoleteDriverSetUp;
import org.raul.lesson_2.testcases.LoginFlow;
import org.raul.lesson_2.testcases.RegistrationFlow;

public class AppTest {
    public static void main(String[] args) {
        WebDriver driver = ObsoleteDriverSetUp.setUpDriver();

        /* Running methods for assignment No.1: RegistrationFlow test cases */
        String urlRegister = "https://qa-course-01.andersenlab.com/registration";
        RegistrationFlow registrationFlow = new RegistrationFlow();
        registrationFlow.setName("Alina");
        registrationFlow.setSurname("Park");
        registrationFlow.setEmail("apark.example.com");
        registrationFlow.setBirthdate("02/09/1999");
        registrationFlow.setPassword("a.park123");
        registrationFlow.setConfirmPassword("apark123");

//        registrationFlow.registrationPasswordMismatch(driver, urlRegister);
//        registrationFlow.registrationEmailFormat(driver, urlRegister);
//        registrationFlow.registrationSuccess(driver, urlRegister);


        /* Running methods for assignment No.1: LoginFlow test cases */
        String urlLogin = "https://qa-course-01.andersenlab.com/login";
        LoginFlow loginFlow = new LoginFlow();
        loginFlow.setEmail("mboone@example.com");
        loginFlow.setPassword("boone123");
        loginFlow.setWrongPassword("w123bne456");

//        loginFlow.loginSuccess(driver, urlLogin);
//        loginFlow.backButtonAfterLogout(driver, urlLogin);
//        String errMessage = loginFlow.invalidLoginCredentials(driver, urlLogin);
//        System.out.println("Validation error: " + errMessage);

/*
        // Running methods for assignment No.2
        String url1 = "http://www.automationpractice.pl/index.php";
        String url2 = "https://zoo.waw.pl/";
        String url3 = "https://www.w3schools.com/";
        String url4 = "https://www.clickspeedtester.com/click-counter/";
        String url5 = "https://andersenlab.com/";

        int arrSize = 5;
        String[] urlArr = {url1, url2, url3, url4, url5};

        WindowHandler windows = new WindowHandler(arrSize);
        windows.setUrlArr(urlArr);
        windows.openUrls(5);

        for (Map.Entry<String, String> entry : windows.getTitleAndUrl().entrySet()) {
            System.out.println("Title: " + entry.getValue() + ", URL: " + entry.getKey());
        }

        windows.closeSpecificWindow("Zoo");
*/

        String url = "http://www.automationpractice.pl/index.php";
/*
        // Running methods for assignment No.3
        driver.get(url);
        WebElement elementA = driver.findElement(By.className("blockbestsellers"));
        WebElement elementB = driver.findElement(By.className("login"));

        ElementComparison elementComparison = new ElementComparison();
        elementComparison.compareElements(elementA, elementB);
*/

/*
        // Running methods for assignment No.4
        PageInteractions page = new PageInteractions();
        page.webAutoPractice(driver, url);
*/
    }
}
