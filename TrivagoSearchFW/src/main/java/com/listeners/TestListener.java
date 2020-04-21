package com.listeners;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.trivago.base.TestBase;



public class TestListener extends TestBase implements ITestListener {
	
	String filePath = "D:\\Screenshots\\Trivago\\";
	
	
	
	
    public void onTestFailure(ITestResult result) {
    	
    	System.out.println("***** Error "+ result.getName()+" test has failed *****");
    	
    	
    	if(result.getStatus()==ITestResult.FAILURE);
    	
    	{	
    		String methodName=result.getName().toString().trim();
    		ITestContext context = result.getTestContext();
    		
    		test.log(LogStatus.FAIL,"***** Error "+ result.getName()+" test has failed *****");
    		test.log(LogStatus.FAIL, result.getThrowable());
    		String path = takeScreenShot(methodName, driver);
    		test.log(LogStatus.FAIL, test.addScreenCapture(path));
    		extent.endTest(test);
    		
    		
    		
    	}
    	
       
    	
    	
    }
    
    public String takeScreenShot(String methodName, WebDriver driver) {
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with test method name 
            try {
            	
				FileUtils.copyFile(scrFile, new File(filePath+ methodName+ ".png"));
				//System.out.println("***Placed screen shot in "+filePath+" ***");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
            return filePath+ methodName + ".png";
    }
    
    
	public void onFinish(ITestContext context) {
		
		extent.endTest(test);
		extent.flush();
		extent.close();
	}
  
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   
    	
    	if(result.getStatus()==ITestResult.SUCCESS) {
    		
    		test.log(LogStatus.PASS,result.getName()+" test has passed *****");
    		extent.endTest(test);
    	}
    	
    }

    public void onTestSkipped(ITestResult result) {  
    	if(result.getStatus()==ITestResult.SKIP) {
    		test.log(LogStatus.SKIP,result.getName()+" test has skipped *****");
    		extent.endTest(test);
    	}
    }
    	

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {  
    	extent = new ExtentReports("D:\\Screenshots\\Trivago\\" + "Extent.html",true);
    	
    }
}  
