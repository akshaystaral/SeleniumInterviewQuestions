package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropdown {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();

		// Product Type
		WebElement dropdown1 = driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']"));
		dropdown1.click();
		List<WebElement> productTypes = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		//System.out.println("Number of Options in Drop down: " + productTypes.size());
		Selectdropdown(productTypes,"Accounts");
		System.out.println("Product Type:" +dropdown1.getText());
		
	/*	for (WebElement ptype : productTypes) {
			if (ptype.getText().equals("Accounts")) {
				ptype.click();
				break;
			}
		} */

		// Products
		WebElement  dropdown2 =driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']"));
		dropdown2.click();
		List<WebElement> products = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
		Selectdropdown(products,"Salary Accounts");
		System.out.println("Product :" +dropdown2.getText());
//		for (WebElement product : products) {
//			if (product.getText().equals("Salary Accounts")) {
//				product.click();
//				break;
//			}
//		}
		driver.quit();
	}

	public static void Selectdropdown(List<WebElement> options, String value) {
		for (WebElement option : options) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		} 
	}
}
