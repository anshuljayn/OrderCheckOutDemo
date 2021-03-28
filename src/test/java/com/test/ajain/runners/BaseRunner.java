package com.test.ajain.runners;

import automation.library.cucumber.selenium.RunnerClassSequential;
import automation.library.reporting.TextReport;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;


@CucumberOptions(
        plugin = {"automation.library.reporting.adapter.ExtentCucumberAdapter:"},
        features = {"classpath:features"},
        glue = {"com/test/ajain/steps", "com/test/ajain/hooks"}
        )

public class BaseRunner extends RunnerClassSequential {

    @AfterTest
    public void teardown() {
        //some code here
    }
}