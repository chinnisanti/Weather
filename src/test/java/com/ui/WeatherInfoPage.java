package com.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WeatherInfoPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	@FindBy(xpath="//div[@class='cur-con-weather-card__body']//div[@class='temp']")
	private WebElement currentTemp;
	
	
	public WeatherInfoPage(WebDriver driver) {
	
		this.driver= driver;
		PageFactory.initElements( driver, this); 
	}
	
	public float getCurrentTempAsFloat() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(currentTemp));
		
		String currentTempAsString = currentTemp.getText();
		float currenttempAsFloat = Float.parseFloat(currentTempAsString.substring(0, currentTempAsString.indexOf("C")-1));
		System.out.println(currenttempAsFloat);
		return currenttempAsFloat;
		//System.out.println(currentTemp.getText());
		//convertTemp(currentTemp.getText());
		
		}
	
	
	

}
