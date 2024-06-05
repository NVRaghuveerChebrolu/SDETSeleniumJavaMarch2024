package stepdefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Pages.AlertsPOM;
import com.utility.Constants;
import com.utility.Library;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidateAlertsUsingBDDApproach extends Library {
	
	@Given("User Launch Broswer specified in properties file and load the DemoQA Url")
	public void user_launch_broswer_specified_in_properties_file_and_load_the_demo_qa_url() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		ReadPropertiesFile();
		LaunchBrowser();
		StartExtentReport();
	}


	@Given("User is on Login Page of Alerts")
	public void user_is_on_login_page_of_alerts() throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions

		ExtTest = ExtReports.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.get(objProp.getProperty("AlertsURL"));
		PageLoadTimeOut();
		Thread.sleep(5000);
	}

	@When("User clicks on click me button of the nommal alert")
	public void user_clicks_on_click_me_button_of_the_nommal_alert() {
		// Write code here that turns the phrase above into concrete actions
		AlertsPOM objAlertsPOM = new AlertsPOM(driver);
		// objAlertsPOM.NormalAlert.click();
		objAlertsPOM.ClickOnNormalAlert();

	}

	@Then("validate text of the normal alert and accept")
	public void validate_text_of_the_normal_alert_and_accept() {
		// Write code here that turns the phrase above into concrete actions
		Alert objAlert = driver.switchTo().alert();
		String titleOfNormalAlert = objAlert.getText();
		Assert.assertEquals(titleOfNormalAlert, Constants.NormalAlertText);
		objAlert.accept();

	}

	@When("User clicks on click me button of the Timer alert")
	public void user_clicks_on_click_me_button_of_the_timer_alert() {
		// Write code here that turns the phrase above into concrete actions
		AlertsPOM objDemoQaAlertsPOM = new AlertsPOM(driver);
		scrollIntoView(objDemoQaAlertsPOM.TimerAlertButton);
		objDemoQaAlertsPOM.TimerAlertButton.click();
	}

	@Then("validate text of the Timer alert and accept")
	public void validate_text_of_the_timer_alert_and_accept() {
		// Write code here that turns the phrase above into concrete actions
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.ExplicitWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert objAlert = driver.switchTo().alert();
		String TextOfNormalAlert = objAlert.getText();
		Assert.assertEquals(TextOfNormalAlert, Constants.TimerAlertText);
		objAlert.accept();
	}

}
