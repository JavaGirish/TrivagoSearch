package com.trivago.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trivago.base.TestBase;
import com.trivago.util.TestUtil;

public class BookingPage extends TestBase{
	
	@FindBy(id= "update-availability-button")
	WebElement updateBtn;
	
	@FindBy(xpath = "//div[contains(@class,'pagination__pages')]")
	WebElement pagination;
	
	@FindBy(id="mock-book-button")
	WebElement reserveBtn;

	
	public BookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	

	
	
	public void selectHotel() throws InterruptedException {
		TestUtil.wait(45, pagination);
		ArrayList<WebElement> ele = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//li[@class='hotel-item item-order__list-item js_co_item']"));

		ArrayList<WebElement> hotelName = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//span[contains(@class,'name')]"));
		ArrayList<WebElement> price = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//strong[contains(@class,'best-price')]"));
		
		for(int i=0;i<ele.size();i++) {
		
		if(hotelName.get(i).getText().equalsIgnoreCase("Silkari Suites Chatswood")) {
			
			
			price.get(i).click();
			
			TestUtil.switchtoWindow();
			
			TestUtil.wait(TestUtil.LONG_WAIT, updateBtn);
			
			WebElement update= driver.findElement(By.id("update-availability-button"));
			update.click();
			
				
		}
		
		}
	
	}

}
