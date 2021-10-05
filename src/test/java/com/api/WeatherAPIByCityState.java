package com.api;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Properties;

import com.common.BaseClass;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class WeatherAPIByCityState extends BaseClass{
	
	public float runWeatherAPIByCityState(String cityState) throws FileNotFoundException {
		
	Properties prop = readProperties("Config.properties");
	//String cityState = prop.getProperty("cityState");
	String apiKey = prop.getProperty("apiKey");
	String baseURI = prop.getProperty("accuweather.api.uri");
	
	HashMap<String, String> params = new HashMap<String,String>();
	params.put("q", cityState);
	params.put("appid", apiKey);
	params.put("units", "Metric");
	
	Response resp = doGet(baseURI, params);
	JsonPath jsonResp = resp.jsonPath();
	
	return jsonResp.get("main.temp");
	
	
	}

}
