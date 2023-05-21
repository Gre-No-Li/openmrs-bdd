package com.academy.techcenture.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/academy/techcenture/features/"} ,
        glue = {"com/academy/techcenture/step_defs", "com/academy/techcenture/hooks"},
        dryRun = false,
        tags = "@regression",
        plugin={"pretty", "junit:target/JUNITReport/report.xml",
                "json:target/JSONReport/report.json",
                "html:target/HtmlReport/report.html"}

)
public class RunnerRegression {

}
