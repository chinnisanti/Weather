package com.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.util.TestListener;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseClass extends TestListener{
	
public WebDriver driver;	
public Properties prop;

@BeforeMethod	
public void openBrowser() {
		
	try {
	    //Reading the property file under resource folder to fetch values  
        prop = readProperties("config.properties");
        String baseURL = prop.getProperty("baseURL");
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}    
       
     catch (IOException ex) {
        ex.printStackTrace();
    }


	
}	

@AfterMethod
public void closeBrowser(){
	driver.quit();
}


public  WebDriver getDriver(){
	return driver;
}

public  Properties getProperties(){
	return prop;
}

public Properties readProperties(String fileName) throws FileNotFoundException {
	InputStream input = this.getClass()
		       .getClassLoader()
		       .getResourceAsStream(fileName);
		Properties prop = new Properties();
	try {
		prop.load(input);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return prop;
	
}


public Response doGet(String serviceName, HashMap<String,String> param) {

	Response resp = null;
	try {
		 
		resp = RestAssured.given()
				.queryParams(param)
				.when()
				.get(serviceName);
		String jsonString = resp.asString();
		System.out.println("jsonString=="+jsonString);
		
		}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	
	return resp;
	
}

}
