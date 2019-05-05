package com.trivago.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.trivago.base.TestBase;
import com.trivago.pages.HomePage;
import com.trivago.pages.ResultsPage;
import com.trivago.util.TestUtil;

public class ResultsPageTest extends TestBase{
	HomePage homePage;
	TestUtil testUtil;
	ResultsPage resultsPage;

	public ResultsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		homePage = new HomePage();
		testUtil = new TestUtil();
		resultsPage= new ResultsPage();
	}
	
	@Test
	public void printdetails() {
		homePage.enterCity();
		homePage.selectCheckInDate();
		homePage.selectCheckOutDate();
		homePage.selectRoomType();
		homePage.clickSearchBtn();
		resultsPage.getTotalSearchResults();
		
		
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
//	
}
