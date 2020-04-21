package com.trivago.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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

	@BeforeClass
	public void setUp() {
		initilization();
		homePage = new HomePage();
		testUtil = new TestUtil();

	}

	@Test(priority = 1)
	public void trivagoPageTitleTest() {
		//test= extent.startTest("trivagoPageTitleTest");
		String title = homePage.pageTitleTest();
		System.out.println();

		Assert.assertEquals(title, "trivago.in - Compare hotel prices worldwide");
	}

	@Test(priority = 2)
	public void trivagoLogoTest() {
		//test= extent.startTest("trivagoLogoTest");
		Assert.assertTrue(homePage.validateTrivagoLogo());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
