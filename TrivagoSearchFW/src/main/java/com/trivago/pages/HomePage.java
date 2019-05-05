package com.trivago.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trivago.base.TestBase;
import com.trivago.util.TestUtil;

public class HomePage extends TestBase {
	
	

	@FindBy(xpath = "//a[@class='hero__link']")
	WebElement trivagoLogo;

	@FindBy(id = "horus-querytext")
	WebElement cityTextBox;

	@FindBy(xpath = "//span[contains(@class,'checkin')]")
	WebElement checkinDate;

	@FindBy(xpath = "//button[contains(@class,'checkout')]")
	WebElement checkoutDate;

	@FindBy(id = "ssg-suggestions")
	WebElement citySuggestionBox;

	@FindBy(xpath = "//span[@class='ssg-title']//mark[text()= 'Sydney']")
	WebElement cityDropdown;

	@FindBy(xpath = "//td//time[@datetime='2019-05-23']")
	WebElement selectCheckinDate;

	@FindBy(xpath = "//td//time[@datetime='2019-05-25']")
	WebElement selectCheckoutDate;

	@FindBy(xpath = "//div[@class='df_overlay']")
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
		WebElement InDate = driver.findElement(By.xpath("//td//time[@datetime= '" + TestUtil.checkinDate + "']"));
		TestUtil.wait(15, InDate);
		InDate.click();

	}

	public void selectRoomType() {
		roomType.click();
		WebElement roomtype = driver.findElement(By.xpath("//span[text()='" + TestUtil.roomType + "']"));
		TestUtil.wait(15, roomtype);
		roomtype.click();

	}

	public void selectCheckOutDate() {

		WebElement outDate = driver.findElement(By.xpath("//td//time[@datetime= '" + TestUtil.checkOutDate + "']"));
		TestUtil.wait(15, outDate);
		outDate.click();

	}

	public void enterCity() {
		cityTextBox.sendKeys(prop.getProperty("city"));
		TestUtil.wait(20, citySuggestionBox);
		cityDropdown.click();

	}

	public boolean validateTrivagoLogo() {
		return trivagoLogo.isDisplayed();
	}

	public String pageTitleTest() {
		return driver.getTitle();
	}

	public ResultsPage clickSearchBtn() {
		searchBtn.click();
		
		return new ResultsPage();

	}

}
