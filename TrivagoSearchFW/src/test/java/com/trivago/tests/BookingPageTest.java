package com.trivago.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.trivago.base.TestBase;
import com.trivago.pages.BookingPage;
import com.trivago.pages.HomePage;
import com.trivago.pages.ResultsPage;
import com.trivago.util.TestUtil;

public class BookingPageTest extends TestBase{

	HomePage homePage;
	TestUtil testUtil;
	ResultsPage resultsPage;
	BookingPage bookingPage;

	public BookingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		homePage = new HomePage();
		testUtil = new TestUtil();
		resultsPage= new ResultsPage();
		bookingPage= new BookingPage();
	}
	
	@Test
	public void printdetails() throws InterruptedException {
		homePage.enterCity();
		homePage.selectCheckInDate();
		homePage.selectCheckOutDate();
		homePage.selectRoomType();
		homePage.clickSearchBtn();
		bookingPage.selectHotel();
		
		
		
	}
	
	
	
	
}
