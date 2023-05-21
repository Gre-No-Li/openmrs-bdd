package com.academy.techcenture.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/academy/techcenture/features/"} ,
        glue = {"com/academy/techcenture/step_defs", "com/academy/techcenture/hooks"},
        tags = "@smoke",
        plugin = {
                "summary",
                "pretty",
                "json:target/cucumber-report",
                "html:target/cucumber-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }, monochrome = true)
public class RunnerSmoke {

}
