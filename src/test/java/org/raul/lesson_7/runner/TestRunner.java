package org.raul.lesson_7.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-report/cucumber.html",
                "json:target/cucumber-report/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"org.raul.lesson_7.stepdefinitions"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
