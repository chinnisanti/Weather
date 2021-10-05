package com.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{
	@FindBy(name="query")
	private WebElement searchBox;
	
	@FindBy(className="icon-search")
	private WebElement searchIcon;
	
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements( driver, this); 
	}

	public void searchCityState(String cityState) {
	wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(searchBox));
	searchBox.sendKeys(cityState);
	searchIcon.click();
	
		
		
	}
}
