package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features=".\\src\\test\\java\\features\\ValidateAlerts.feature",
	glue= {"stepdefinitions"},
	plugin= {"pretty","html:Report1"},
	dryRun=true,
	monochrome=true
		)
public class TestRunner {
}
