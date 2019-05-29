package com;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class EaseMyTripTest {

	WebDriver driver;

	@Test
	public void Booking() {
		WebElement from = driver.findElement(By.xpath("//input[@id='FromSector_show']"));
		from.clear();
		from.sendKeys("Bangalore");
		WebElement to = driver.findElement(By.xpath("//input[@id='Editbox13_show']"));
		to.clear();
		to.sendKeys("Delhi");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='ddate']")).click();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
		LocalDateTime now = LocalDateTime.now();
		String date = (dtf.format(now));
		System.out.println(date);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='box']//li[contains(text(),'30')]")).click();
		driver.manage().timeouts().implicitlyWait(31, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@onclick='myFunction4()']/span[@class='drpNoTrv']")).click();
		driver.findElement(By.xpath("//div[@id='myDropdown_n']//input[@class='plus_box1']")).click();
		driver.findElement(By.xpath("//div[@id='myDropdown_n']//input[@class='plus_boxChd']")).click();
		driver.findElement(By.xpath("//a[@id='traveLer']")).click();
		driver.findElement(By.xpath("//a[@onclick='myFunction9()']")).click();
		driver.findElement(By.xpath("//div[@id='myDropdown_n9']//label/input[@value='2']")).click();
		driver.findElement(By.xpath("//a[@id='tripType']")).click();
		driver.findElement(By.xpath("//div[@class='mobile-wi1 flig-show1']//input[@value='Search']")).click();
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		WebElement priceSlider = driver.findElement(By.xpath("//div[@id='slider-range']"));
		Dimension sliderSize = priceSlider.getSize();
		int sliderWidth = sliderSize.getWidth();
		int xCoord = priceSlider.getLocation().getX();

		Actions builder = new Actions(driver);
		builder.moveToElement(priceSlider).click().dragAndDropBy(priceSlider, xCoord + sliderWidth, 0).build()
				.perform();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='pri1']/i")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("//div[@class='row no-margn fltResult ng-scope AC']//button[@class='btn  book-bt-n']"))
				.click();
		String printSummary = driver.findElement(By.xpath("//div[@class='stickyheader']//div[@id='divFareSummary']"))
				.getText();
		System.out.println(printSummary);
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		String baseUrl = "https://www.easemytrip.com";
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
