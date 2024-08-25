package com.BDD;

import java.io.IOException;

import org.testng.Assert;

import com.Pages.GmoOnlinePOM;
import com.utility.Constants;
import com.utility.Library;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidateGmoOnlineApp extends Library{

	@Given("User is on login page of GMO Online App")
	public void user_is_on_login_page_of_gmo_online_app() throws IOException {
	
		LaunchBrowser();
		// Write code here that turns the phrase above into concrete actions
		driver.get(objProp.getProperty("GmoOnlineURL"));
		PageLoadTimeOut();
		String HomePageTitle = driver.getTitle();
		System.out.println("HomePageTitle:" + HomePageTitle);
		Assert.assertEquals(HomePageTitle, Constants.GmoOnlineTitle);
	
	}

	@Given("I click on GmoOnline Login Page")
	public void i_click_on_gmo_online_login_page() {
		// Write code here that turns the phrase above into concrete actions
		GmoOnlinePOM objgmoOnlinePOM = new GmoOnlinePOM(driver);
		objgmoOnlinePOM.clickOnEnterGmoOnlineButton();
		String OnlineCatalogTitle = driver.getTitle();
		System.out.println("OnlineCatalogTitle:" + OnlineCatalogTitle);
		Assert.assertEquals(OnlineCatalogTitle, Constants.OnlineCatalogTitle);
		
	}

	@When("I add quantity for hiking boots product")
	public void i_add_quantity_for_hiking_boots_product() {
		// Write code here that turns the phrase above into concrete actions
		GmoOnlinePOM objgmoOnlinePOM = new GmoOnlinePOM(driver);
		objgmoOnlinePOM.QTY_GLASSES.clear();
		objgmoOnlinePOM.QTY_GLASSES.sendKeys(Constants.QTY_Glasses);


	}

	@When("user clicks on submit button")
	public void user_clicks_on_submit_button() {
		// Write code here that turns the phrase above into concrete actions
		GmoOnlinePOM objgmoOnlinePOM = new GmoOnlinePOM(driver);
		objgmoOnlinePOM.PlaceAnOrder.click();
	
	}

	@Then("I validate the place order page is displayed")
	public void i_validate_the_place_order_page_is_displayed() {
		// Write code here that turns the phrase above into concrete actions
		GmoOnlinePOM objgmoOnlinePOM = new GmoOnlinePOM(driver);
		String placeOrderTitle = driver.getTitle();
		System.out.println("placeOrderTitle:" + placeOrderTitle);
		Assert.assertEquals(placeOrderTitle, Constants.PlaceOrderTitle);
		String UnitPrice = objgmoOnlinePOM.UnitPrice.getText();
		System.out.println("UnitPrice:" + UnitPrice);
		String floatValueOfUnitPrice = UnitPrice.substring(2).trim();
		System.out.println("floatValueOfUnitPrice:" + floatValueOfUnitPrice);
		float calculatedUnitprice = Float.parseFloat(floatValueOfUnitPrice) * 3;
		System.out.println("calculatedUnitprice:" + calculatedUnitprice);
		String totalPriceDisplayed = objgmoOnlinePOM.TotalPriceDisplayed.getText();
		float floatValueOfTotalPrice = Float.parseFloat(totalPriceDisplayed.substring(2).trim());
		Assert.assertEquals(calculatedUnitprice, floatValueOfTotalPrice);
		System.out.println("floatValueOfTotalPrice:" + floatValueOfTotalPrice);

	}

}
