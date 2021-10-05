package com.util;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	
	public static ExtentReports extent;
	
	public static ExtentReports createInstance() {
		String fileName = getReportName();
		String directory = System.getProperty("user.dir") + "\\reports\\";
		 
		File reportDirectory = new File(directory);
		if (!reportDirectory.exists()) {
			reportDirectory.mkdir();
		}
		
		String path = directory+fileName;
		System.out.println("path="+path);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		htmlReporter.config().setTheme(Theme.STANDARD);
	    htmlReporter.config().setDocumentTitle(path);
	    htmlReporter.config().setEncoding("utf-8");
	    htmlReporter.config().setReportName(path);	
	    
	    extent =  new ExtentReports();
	    extent.attachReporter(htmlReporter);
	    
	return extent;
	}
	
	
	public static String getReportName() {
		Date d = new Date();
		String fileName = "AutomationReport_" +d.toString().replace(":", "-") +".html";
		 
		return fileName;
}	
	
	
}
