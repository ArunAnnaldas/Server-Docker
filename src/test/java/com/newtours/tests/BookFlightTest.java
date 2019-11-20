package com.newtours.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Tests.BaseTest;
import com.newTours.pages.FindFlightsPage;
import com.newTours.pages.FlightConfirmationPage;
import com.newTours.pages.FlightDetails;
import com.newTours.pages.RegistrationConfirmation;
import com.newTours.pages.RegistrationPage;

public class BookFlightTest extends BaseTest{

	private String noOfPassengers;
	private String expectedPrice;

	@BeforeTest
	@Parameters({"noOfPassengers","expectedPrice"})
	public void settinUpParameters(String noOfPassengers, String expectedPrice) {
		this.noOfPassengers=noOfPassengers;
		this.expectedPrice=expectedPrice;
	}

	@Test
	public void registrationPageTest(){
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.goTo("http://newtours.demoaut.com/mercuryregister.php?osCsid=e4843d8bcde2bfdbcebfe3002a3871fd");
		regPage.enterUserDetails("selenium", "docker");
		regPage.enterUserCreds("selenium", "docker");
		regPage.submit();
	}

	@Test(dependsOnMethods = "registrationPageTest")
	public void registrationConfirmationPage() {
		RegistrationConfirmation regConfirm = new RegistrationConfirmation(driver);
		regConfirm.goToFlightDetailsPage();
	}

	@Test(dependsOnMethods = "registrationConfirmationPage")
	public void flightDetailsPage() {
		FlightDetails flightDetailsPage = new FlightDetails(driver);
		flightDetailsPage.selectPassengers(noOfPassengers);
		flightDetailsPage.goToFLightsPage();
	}

	@Test(dependsOnMethods = "flightDetailsPage")
	public void findFlightsPage() {
		FindFlightsPage findFlightsPage = new FindFlightsPage(driver);
		findFlightsPage.submitFindFlightsPage();
		findFlightsPage.goToFlightConfirmationPage();
	}

	@Test(dependsOnMethods = "findFlightsPage")
	public void flightConfirmationPage() {
		FlightConfirmationPage flightConfPage = new FlightConfirmationPage(driver);
		String actualPrice = flightConfPage.getPrice();
		Assert.assertEquals(actualPrice, expectedPrice);
	}
	
}
