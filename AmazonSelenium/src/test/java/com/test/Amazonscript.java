package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.JavascriptExecutor;

public class Amazonscript {

	WebDriver driver;
	String mainPageTitle;
	ArrayList<String> tabs;
	String parentWindowHandle;

	@Test(priority=0)
	public void verifyCart() {
		mainPageTitle = driver.getTitle();
		driver.findElement(By.xpath("//div[@id='nav-shop']//a")).click();
		parentWindowHandle = driver.getWindowHandle();
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		driver.findElement(By.xpath("//a[text()='Speakers']")).click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement product = driver.findElement(By.xpath(
				"//li[@id='result_1']//a[@class='a-link-normal s-access-detail-page s-color-twister-title-link a-text-normal']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", product);
		String price = driver.findElement(By.xpath("//li[@id='result_1']//span[@class='a-size-base a-color-price s-price a-text-bold']")).getText();
		System.out.println("Price Rs. "+price);
		driver.findElement(By.xpath(
				"//li[@id='result_1']//a[@class='a-link-normal s-access-detail-page s-color-twister-title-link a-text-normal']"))
				.sendKeys(selectLinkOpeninNewTab);
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		String productName = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
		System.out.println(productName);
		driver.findElement(By.xpath("//*[@title='Add to Shopping Cart']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("mcmdivya@gmail.com");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("dbbmrctaa");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='Cart']")).click();
		String cartName = driver.findElement(By.xpath(
				"//div[@class='sc-list-body sc-java-remote-feature']//span[@class='a-size-medium sc-product-title a-text-bold']"))
				.getText();
		Assert.assertEquals(cartName, productName);
		System.out.println("Product Name Matched");
		driver.close();
		driver.switchTo().window(parentWindowHandle);
	}

	@Test(priority=1)
	public void VerifyHomePage() {

		WebElement logo = driver.findElement(By.xpath("//a[@aria-label='Amazon']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", logo);
		driver.findElement(By.xpath("//a[@aria-label='Amazon']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String titleAfterSwitching = driver.getTitle();
		Assert.assertEquals(mainPageTitle, titleAfterSwitching);

	}

	@BeforeSuite
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		String baseUrl = "http://www.amazon.in/";
		driver.get(baseUrl);
		driver.manage().window().maximize();

	}

	@AfterSuite
	public void afterClass() {
		driver.quit();
		System.exit(0);
	}

}
