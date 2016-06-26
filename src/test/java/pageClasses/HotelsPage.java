package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelsPage {
	WebDriver driver;

	public HotelsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@data-title='HOTELS']//a")
	public WebElement HOTELS_Tab;

	@FindBy(xpath = "//div[@id='s2id_hotelicon']/a")
	public WebElement locationBox;

	@FindBy(name = "checkin")
	public WebElement checkInDate;

	@FindBy(name = "checkout")
	public WebElement checkOutDate;

	@FindBy(xpath = "//div[@id='HOTELS']//select[@name='adults']")
	public WebElement adultPassenger;

	@FindBy(xpath = "//div[@id='HOTELS']//select[@name='child']")
	public WebElement childPassenger;

	@FindBy(xpath = ".//*[@id='HOTELS']/form/div[8]/div/button")
	public WebElement searchButton;
	
	
	public void clear(WebDriver driver){
		checkInDate.clear();
		checkOutDate.clear();
	}

	public void fillInLocation(WebDriver driver, String _location) throws Exception {

		locationBox.click();

		WebElement locationContainer = driver.findElement(By.xpath(".//*[@id='select2-drop']/ul"));

		List<WebElement> locations = locationContainer.findElements(By.tagName("li"));

		WebElement inputBox = driver.findElement(By.xpath(".//*[@id='select2-drop']/div/input"));
		inputBox.sendKeys(_location);
		driver.findElement(By.xpath(".//*[@id='select2-drop']/ul/li/div")).click();

	}
	
	public void clickSearchButton(WebDriver driver)throws Exception{
		
		WebDriverWait wd =  new WebDriverWait(driver, 5);
		wd.until(ExpectedConditions.elementToBeClickable(searchButton));
		
		searchButton.click();
	}

}
