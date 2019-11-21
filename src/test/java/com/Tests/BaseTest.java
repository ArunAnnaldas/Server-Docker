package com.Tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	protected WebDriver driver;

	@BeforeTest
	public void setupDriver(ITestContext itc) throws MalformedURLException {
		
		String host="localhost";
		DesiredCapabilities dc;
		System.out.println("Put sleep to wait for hub registration to happen");
		try {
			
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(System.getProperty("BROWSER")!=null &&
				System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
			dc=DesiredCapabilities.firefox();
		}
		else {
			dc = DesiredCapabilities.chrome();
		}
		
		if(System.getProperty("HUB_HOST")!=null) {
			host = System.getProperty("HUB_HOST");
		}
		
		//Adding the below 2 lines to demonstrate the capability in Zalenium
		//String testName=itc.getCurrentXmlTest().getName();
		//dc.setCapability("name", testName);
		
		/*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/exe/chromedriver.exe");
		this.driver = new ChromeDriver(dc);*/
		
		//run when you are using docker image on your local host machine.
		String completeURL = "http://" + host + ":4444/wd/hub";
		this.driver=new RemoteWebDriver(new URL(completeURL), dc);
		
	}

	@AfterTest
	public void quitBrowser() {
		this.driver.quit();
	}

}
