package mypackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptexecutorDemo {
	public static WebElement logo;

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		// Syntax
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript(Script, args);

		// Flashing Element
		logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
		JavascriptUtil.flash(logo, driver);

		// Drawing border & take screenshot of the Element
		// WebElement logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
		JavascriptUtil.drawBorder(logo, driver);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\Screenshots\\logo.png");
		FileUtils.copyFile(src, trg);

		// Get the title of the page
		String title = JavascriptUtil.getTitleByJS(driver);
		System.out.println("Title of WebPage : " + title);

		// Click action
		WebElement mobile = driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));
		JavascriptUtil.clickElementbyJS(mobile, driver);

		// Generate alert
		JavascriptUtil.generateAlert(driver, "Successfully Navigated to Mobile Shopping Page.");
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

		// Refreshing the page
		JavascriptUtil.refreshBrowserbyJS(driver);

		// Scrolling down page
		JavascriptUtil.scrollPageDown(driver);
		Thread.sleep(5000);

		// Scroll up page
		JavascriptUtil.scrollPageUp(driver);
		Thread.sleep(5000);

		// Zoom-In
		JavascriptUtil.zoomPagebyJS(driver);
		Thread.sleep(5000);

		// Zoom-Out page
		JavascriptUtil.zoomoutPagebyJS(driver);
		Thread.sleep(5000);

		driver.quit();

	}
}