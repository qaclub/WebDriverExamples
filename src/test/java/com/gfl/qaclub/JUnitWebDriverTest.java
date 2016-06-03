package com.gfl.qaclub;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JUnitWebDriverTest {
	
	// Create object of interface WebDriver.	 
	WebDriver driver;
	
	//Annotation that sends to JUnit message that this method should be executed BEFORE test method
	@Before
	public void setUp() {
		/*
		 * Initialize object driver. According to internal realization of selenium
		 * we can initialize driver object as
		 * WebDriver driver = new FirefoxDriver();
		 * or
		 * WebDriver driver = new ChromeDriver();
		 * not
		 * WebDriver driver = new WebDriver();
		 * but be careful with other stuff :-)
		 */
		driver = new FirefoxDriver();
		
		//Maximize window of FF
		driver.manage().window().maximize();
	}
	
	//Annotation that sends to JUnit message that this method should be executed as TEST method
	@Test
	public void testJUnitWebDriver() {
		//Open FF and go to https://google.com.ua. Also you can use this variant -> driver.navigate().to("https://google.com.ua");
		driver.get("https://google.com.ua");
		
		//Send 'Hosting Max' string to the search form
		driver.findElement(By.name("q")).sendKeys("Hosting Max");
		
		/*
		 * Wait for 5 seconds to see that our actions were executed
		 * BUT!!! DO NOT USE IN YOUR SCRIPTS IN THE FUTURE, THIS IS VERY BAD PRACTIC
		 * We'll learn about implicitly and explicitly waits on next lectures.
		 */
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Annotation that sends to JUnit message that this method should be executed AFTER test method
	@After
	public void tearDown() {
		//Close browser and finish work of driver
		driver.quit();
	}	
}
