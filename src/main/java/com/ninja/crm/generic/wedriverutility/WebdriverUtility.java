package com.ninja.crm.generic.wedriverutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class WebdriverUtility {
	
	
	public void setImplicitlyWait(WebDriver driver,int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		
	}

	
	
}
