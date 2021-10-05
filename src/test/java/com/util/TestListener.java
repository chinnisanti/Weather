package com.util;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListener implements ITestListener {
 
private static ExtentReports extent  = ExtentManager.createInstance();
private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

 
	public void onStart(ITestContext context) {
		 
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		if (extent !=null) {
			extent.flush();
		}
 
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTest test =extent.createTest(result.getTestClass().getName() + "::" +
											result.getMethod().getMethodName());
	 
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		String logText = "<b> Test Method" + result.getMethod().getMethodName() + "Successful</b>";
		Markup m= MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS,m);
	 
		System.out.println("after sucess report generation");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		String methodName = result.getMethod().getMethodName();
		
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		
		extentTest.get().fail("<details><summary><b><u><font color = red>" +
							"Exception occured, click to see details:" +"</font></u></b></summary>"
							+ exceptionMessage.replace(",", "<br>")+ "</details> \n");
		
		String logText = "<b> Test Method" + methodName + "Failed</b>";
		Markup m= MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL,m);
		System.out.println("after Failure report generation");
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		String logText = "<b> Test Method" + result.getMethod().getMethodName() + "Skipped</b>";
		Markup m= MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		extentTest.get().log(Status.SKIP,m);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}