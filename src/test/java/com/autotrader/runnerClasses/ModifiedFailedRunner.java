package com.autotrader.runnerClasses;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * if any scenario fails, we are storing the fail details
 * in rerun.txt and we are only calling failed scenarios.
 */


@RunWith(Cucumber.class)
@CucumberOptions(
        //@target olmali diger turli rerun.txt dosyasini bulamaz
        features = {"@target/rerun.txt",},
        glue = "com/autotrader/stepDefinitions",

        plugin = {
                "html:target/rerun-default-cucumber-reports_first",
                "json:target/cucumber_failure_first.json",
                "rerun:target/rerun_first.txt"
        }

)
public class ModifiedFailedRunner {
}
