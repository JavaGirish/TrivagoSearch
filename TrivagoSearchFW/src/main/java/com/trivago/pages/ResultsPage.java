package com.trivago.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trivago.base.TestBase;
import com.trivago.util.TestUtil;

public class ResultsPage extends TestBase {

	@FindBy(xpath = "//ol[contains(@class,'hotellist')]")
	WebElement searchResultGrid;

	@FindBy(xpath = "//div[contains(@class,'pagination__pages')]")
	public static WebElement pagination;

	
	public ResultsPage() {
		PageFactory.initElements(driver, this);
	}

	public void getTotalSearchResults() {
		TestUtil.wait(45, pagination);
		ArrayList<WebElement> ele = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//li[@class='hotel-item item-order__list-item js_co_item']"));

		ArrayList<WebElement> hotelName = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//span[contains(@class,'name')]"));
		ArrayList<WebElement> price = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//strong[contains(@class,'best-price')]"));

		System.out.println("Total Search Results are " + ele.size());

		HashMap<String, Integer> results = new HashMap<String, Integer>();

		for (int i = 0; i < ele.size(); i++) {
			String name = hotelName.get(i).getText();
			int bestprice = Integer.parseInt(price.get(i).getText().replaceAll("[^0-9]", "").trim());
			results.put(name, bestprice);

		}

		for (Map.Entry<String, Integer> data : results.entrySet()) {
			System.out.println("Hotel: " + data.getKey() + " Best price: " + data.getValue());
		}

	}

}
