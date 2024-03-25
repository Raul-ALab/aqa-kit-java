package org.raul.lesson_7.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.raul.listener.AllureTestListener;
import org.testng.annotations.Listeners;

@Listeners({AllureTestListener.class})
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-report/cucumber.html",
                "json:target/cucumber-report/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"org.raul.lesson_7.stepdefinitions"},
        tags = "@testcase_#L021 or @testcase_#L010 or @testcase_#L01"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
