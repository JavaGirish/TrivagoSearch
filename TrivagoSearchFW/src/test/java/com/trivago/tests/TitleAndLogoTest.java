package com.trivago.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.trivago.base.TestBase;
import com.trivago.pages.HomePage;
import com.trivago.util.TestUtil;

public class TitleAndLogoTest extends TestBase {
	HomePage homePage;
	TestUtil testUtil;

	public TitleAndLogoTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		homePage = new HomePage();
		testUtil = new TestUtil();

	}

	@Test(priority = 1)
	public void trivagoPageTitleTest() {
		String title = homePage.pageTitleTest();

		Assert.assertEquals(title, TestUtil.expectedPageTitle);
	}

	@Test(priority = 2)
	public void trivagoLogoTest() {
		Assert.assertTrue(homePage.validateTrivagoLogo());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
