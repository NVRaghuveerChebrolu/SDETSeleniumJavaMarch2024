package com.BDD;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.Library;

public class Hooks extends Library {

	@Before
	public void setUp() throws IOException {
		// Set the path to the chrome driver executable
		ReadPropertiesFile();

		System.out.println("Before hook: Browser opened and maximized.");
	}

	@After
	public void tearDown() {
		// Close the browser
		if (driver != null) {
			driver.quit();
		}
		System.out.println("After hook: Browser closed.");
	}
}
