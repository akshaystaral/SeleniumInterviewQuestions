package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//How To Locate links in Selenium WebDriver?
//What is the difference between LinkText() and PartialLinkText()?
//How to capture all the links from Web Page?
//What is Broken Link? How to check it?
		
public class HandleLinks {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//Link Text
		//driver.findElement(By.linkText("Today's Deals")).click();
		
		//Partial Link Text
		//driver.findElement(By.partialLinkText("Pay")).click();
		
		//Capture All Links on a Page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		//System.out.println("Number of Links: " + links.size());
		
		//Normal For Loop to 
	/*	for(int i=0; i < links.size(); i++)
		{
			//System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
		} */
		
		for(WebElement link : links)
		{
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
		}
		
	}
}
