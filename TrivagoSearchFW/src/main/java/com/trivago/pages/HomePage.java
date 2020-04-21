package com.trivago.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trivago.base.TestBase;
import com.trivago.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(css = "a[class*='hero__link js-logo-home']")
	WebElement trivagoLogo;

	@FindBy(css = "input[type='search']")
	WebElement cityTextBox;

	@FindBy(xpath = "//span[contains(@class,'checkin')]")
	WebElement checkinDate;

	@FindBy(xpath = "//button[contains(@class,'checkout')]")
	WebElement checkoutDate;

	@FindBy(css = "ul.ssg-suggestions")
	WebElement citySuggestionBox;

	@FindBy(xpath = "//mark[text()='Mumbai']")
	WebElement cityDropdown;

	@FindBy(xpath = "//td//time[@datetime='2020-04-16']")
	WebElement selectCheckinDate;

	@FindBy(xpath = "//td//time[@datetime='2020-04-28']")
	WebElement selectCheckoutDate;

	@FindBy(css = "span[class*='icon-ic dealform-button__icon']")
	WebElement checkoutDropBox;

	@FindBy(xpath = "//button[contains(@class,'roomtype')]")
	WebElement roomType;

	@FindBy(xpath = "//span[text()='Double room']")
	WebElement selectRoomType;

	@FindBy(xpath = "//button[contains(@class,'search')]")
	WebElement searchBtn;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void selectCheckInDate() {
		// checkoutDropBox.click();
		selectCheckinDate.click();
		logger.info("Check in Date selected....");
	}

	public void selectRoomType() {
		// roomType.click();
		WebElement roomtype = driver.findElement(By.xpath("//span[text()='" + TestUtil.roomType + "']"));
		TestUtil.wait(15, roomtype);
		
		roomtype.click();
		logger.info("Room Type Clicked....");

	}

	public void selectCheckOutDate() {
		selectCheckoutDate.click();
		logger.info("Checkout date selected....");
	}

	public void enterCity() {
		logger.info("Entering city Name");
		cityTextBox.sendKeys(prop.getProperty("city"));
		logger.info("City Name Entered....");
		TestUtil.wait(20, citySuggestionBox);
		cityDropdown.click();

	}

	public boolean validateTrivagoLogo() {
		logger.info("Validating Page Logo....");
		return trivagoLogo.isDisplayed();
	}

	public String pageTitleTest() {
		logger.info("Waiting for page title....");
		return driver.getTitle();
		
	}

	public ResultsPage clickSearchBtn() {
		searchBtn.click();
		logger.info("Search Button Clicked....");
		return new ResultsPage();

	}

}
