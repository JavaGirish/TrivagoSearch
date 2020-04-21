package com.trivago.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.trivago.base.TestBase;
import com.trivago.pages.HomePage;
import com.trivago.pages.ResultsPage;
import com.trivago.util.TestUtil;

public class SearchHotelTest extends TestBase {

	HomePage homePage;
	TestUtil testUtil;
	

	public SearchHotelTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		homePage = new HomePage();
		testUtil = new TestUtil();
	}

	@Test
	public void searchHotels() {
		//test= extent.startTest("searchHotels");
		homePage.enterCity();
		homePage.selectCheckInDate();
		homePage.selectCheckOutDate();
		homePage.selectRoomType();
		homePage.clickSearchBtn();

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	
	
}
