package com.cucumber.pageobjectmodel;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = {"src/test/resources/features/HRMLoginPage.feature" },
		glue = {"com.cucumber.pageobjectmodel.definitions"},
		plugin = { "pretty", "html:target/cucumber-reports" },
		monochrome = true
		)

public class CucumberRunnerTest {

}
