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
        features = {"@target/rerun_second.txt",},
        glue = "com/autotrader/stepDefinitions",

        plugin = {
                "html:target/rerun-default-cucumber-reports_third",
                "json:target/cucumber_failure_third.json",
                "rerun:target/rerun_third.txt"
        }

)
public class ModifiedFailedRunner3 {
}
