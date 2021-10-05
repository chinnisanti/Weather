package com.test;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.api.WeatherAPIByCityState;
import com.common.BaseClass;
import com.ui.HomePage;
import com.ui.WeatherInfoPage;
import com.util.TemperatureOutsideRangeException;
import com.util.Utilities;

public class WeatherComparisonTest extends BaseClass {

public Properties prop;

WeatherAPIByCityState weatherAPIByCityState = new WeatherAPIByCityState();


Utilities util = new Utilities();


	@Test(priority = 1)
	public void compareWeatherWithinRange() throws FileNotFoundException, TemperatureOutsideRangeException {
		prop = getProperties();
		HomePage homePage = new HomePage(getDriver());	
		WeatherInfoPage weatherInfoPage = new WeatherInfoPage(getDriver());
		String cityState = prop.getProperty("cityState");
		homePage.searchCityState(cityState);
		float tempUI = weatherInfoPage.getCurrentTempAsFloat();
		float tempAPI = weatherAPIByCityState.runWeatherAPIByCityState(cityState);
		System.out.println("Temperature from UI = " + tempUI);
		System.out.println("Temperature from API = " + tempAPI);
		float variance = Float.parseFloat((prop.getProperty("variance")));
		boolean result = util.weatherComparator(tempUI, tempAPI, variance);
		assert result :"Temperature is Outside permissible Range";
		
	}
		
	@Test(priority = 2)
		public void compareWeatherOutsideRange() throws FileNotFoundException, TemperatureOutsideRangeException {
			prop = getProperties();
			HomePage homePage = new HomePage(getDriver());	
			WeatherInfoPage weatherInfoPage = new WeatherInfoPage(getDriver());
			String cityState = prop.getProperty("cityState");
			homePage.searchCityState(cityState);
			float tempUI = weatherInfoPage.getCurrentTempAsFloat();
			float tempAPI = weatherAPIByCityState.runWeatherAPIByCityState(cityState);
			System.out.println("Temperature from UI = " + tempUI);
			System.out.println("Temperature from API = " + tempAPI);
			
			// ****Adding the variance directly in the Method below*****
			boolean result = util.weatherComparator(tempUI, tempAPI, 2);
			assert result :"Temperature is Outside permissible Range";
			
		
		
	}
}
