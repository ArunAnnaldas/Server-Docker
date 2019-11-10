package com.newTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightsPage {

	
	@SuppressWarnings("unused")
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name="reserveFlights")
	private WebElement firstSubmit;

	@FindBy(name="buyFlights")
	private WebElement secondSubmit;
	
	public FindFlightsPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,30);
		PageFactory.initElements(driver, this);
	}
	
	public void submitFindFlightsPage() {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.firstSubmit));
		this.firstSubmit.click();
	}
	
	public void goToFlightConfirmationPage() {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.secondSubmit));
		this.secondSubmit.click();
	}
}
