package com.utility;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends Library{
	private Library base;
	
	public Hook(Library base) {
		this.base = base;
	}
	
	public Hook() {
		
	}


	@Before
	public void initDriver() throws IOException {
		ReadPropertiesFile();
		LaunchBrowser();
		StartExtentReport();
	}

	@After
	public void teardown() {
		System.out.println("Close browser");
		//driver.quit();
	}
}
