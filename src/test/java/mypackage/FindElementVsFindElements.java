package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementVsFindElements {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://demo.nopcommerce.com/");

//		// findElement
//		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
//		searchBox.sendKeys("Samsung");
//		searchBox.clear();
//
//		// findElement to locate first element from multiple elements on a page
//		WebElement elmntList = driver
//				.findElement(By.xpath("//div[@class='navFooterLine navFooterLinkLine navFooterDescLine']//a"));
//		System.out.println(elmntList.getText());
//
//		// org.openqa.selenium.NoSuchElementException
//		WebElement searchBtn = driver.findElement(By.xpath("//input[@id='nav-test-submit-button']"));

		// FindElements returning a list of web elements
//		List<WebElement> links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
//		System.out.println("Numebr of WebElements Captured: " + links.size());
//		
//		for(WebElement ele : links) {
//			System.out.println("Name of The WebElement: " +ele.getText());
//		}
		
//		// FindElements returning only 1 web element
//		List<WebElement> logo = driver.findElements(By.xpath("//img[@alt='nopCommerce demo store']"));
//		System.out.println("Numebr of WebElements Captured: " + logo.size());
		
		//Return zero as Element is not present
		List<WebElement> elements = driver.findElements(By.xpath("//img[contains(title,'Show products in category Electronics')]"));
		System.out.println(elements.size());

		driver.close();
	}

}
