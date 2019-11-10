package com.newTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetails {

	@SuppressWarnings("unused")
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(name = "passCount")
	private WebElement passengers;

	@FindBy(name = "findFlights")
	private WebElement SubmitButton;

	public FlightDetails(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	public void selectPassengers(String noOfPassengers) {
		this.wait.until(ExpectedConditions.elementToBeClickable(passengers));
		Select sel = new Select(passengers);
		sel.selectByValue(noOfPassengers);
	}

	public void goToFLightsPage() {
		this.SubmitButton.click();
	}

}
