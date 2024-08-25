package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features="src/test/resources/features",
	glue= {"com.BDD"},
	tags = "@Regression",
	plugin= {"pretty","html:target/cucumber-reports.html"},
	//dryRun=true,
	monochrome=true
		)
public class TestRunner {
}
