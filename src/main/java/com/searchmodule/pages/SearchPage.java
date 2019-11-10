package com.searchmodule.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//form[@id='search_form_homepage']/input[@name='q']")
	private WebElement searchTxt;

	@FindBy(id = "search_button_homepage")
	private WebElement searchBtn;

	@FindBy(linkText = "Videos")
	private WebElement videosLink;

	@FindBy(className = "tile--vid")
	private List<WebElement> allVideos;

	@FindBy(xpath = "//div[@class='search__autocomplete']/div/div[1]/span")
	private WebElement autoSuggestion;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	public void goTo() {
		this.driver.get("https://duckduckgo.com/");
		// driver.manage().window().maximize();
	}

	public void doSearch(String keywork) {
		System.out.println("doSearchStarted");
		this.wait.until(ExpectedConditions.visibilityOf(this.searchTxt));
		this.searchTxt.sendKeys(keywork);
		By by = By.xpath("//div[@class='search__autocomplete']//span");
		this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 2));
		this.autoSuggestion.click();
		System.out.println("doSearchCompleted");
	}

	public void goToVideos() {
		System.out.println("GotoVideoStarted");
		this.wait.until(ExpectedConditions.visibilityOf(this.videosLink));
		this.videosLink.click();
		System.out.println("GotoVideoCompleted");
	}

	public int videoLinkCount() {
		this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("tile--vid"), 2));
		System.out.println(this.allVideos.size());
		return allVideos.size();
	}

}
