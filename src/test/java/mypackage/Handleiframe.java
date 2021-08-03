package mypackage;

//1) What is the difference between frame and iframe?
//2) How To Handle iframes in Selenium WebDriver?
//3) How To Switch between multiple iFrames?
//4) How To Work with Inner iFrames?

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handleiframe {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();

		// 1st Frame
		driver.switchTo().frame("packageListFrame"); // Name of the Frame
		driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click();
		driver.switchTo().defaultContent(); // Switch to Main Page

		Thread.sleep(3000);

		// 2nd iframe
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//span[normalize-space()='WebDriver']")).click();
		driver.switchTo().defaultContent(); // Switch to Main Page

		Thread.sleep(3000);

		// 3rd frame
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//div[@class='topNav']//ul[@title='Navigation']//a[.='Help']")).click();
		Thread.sleep(10000);
	}

}
