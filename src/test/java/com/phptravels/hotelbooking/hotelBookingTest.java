package com.phptravels.hotelbooking;

import org.testng.annotations.Test;

import pageClasses.HotelsPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class hotelBookingTest {

	WebDriver driver;
	HotelsPage hp;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Timmy\\workspace\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		hp = new HotelsPage(driver);
		String baseUrl = "http://phptravels.net/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	
	@DataProvider(name = "fieldsInput")
	public Object [][] searchData() {
		
		
		return new Object[][] {{"sing","23/06/2016","29/06/2016"},{"Dub","24/06/2016","30/06/2016"},{"Lond","25/06/2016","28/06/2016"}};
	}
	
	

	@Parameters({ "city", "checkIn", "checkOut" })
	@Test
	public void test(String city, String checkIn, String checkOut) throws Exception {
		hp.HOTELS_Tab.click();
		// driver.findElement(By.xpath(".//*[@id='s2id_hotelicon']/a/span[2]/b")).click();

		hp.fillInLocation(driver, city);
		hp.clear(driver);
		hp.checkInDate.sendKeys(checkIn);
		hp.checkOutDate.sendKeys(checkOut);
		hp.checkOutDate.click();
		hp.clickSearchButton(driver);
		driver.navigate().back();
		//

	}

	@Test(dataProvider = "fieldsInput")
	public void testWithMultipleData(String city, String checkIn, String checkOut) throws Exception {
		hp.HOTELS_Tab.click();
		// driver.findElement(By.xpath(".//*[@id='s2id_hotelicon']/a/span[2]/b")).click();

		hp.fillInLocation(driver, city);
		hp.clear(driver);
		hp.checkInDate.sendKeys(checkIn);
		hp.checkOutDate.sendKeys(checkOut);
		hp.checkOutDate.sendKeys(Keys.ESCAPE);
		hp.checkOutDate.click();
		hp.clickSearchButton(driver);
		driver.navigate().back();
		//

	}

	
	@AfterClass
	public void afterClass() {
	}

}
