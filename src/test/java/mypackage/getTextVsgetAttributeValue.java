package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getTextVsgetAttributeValue {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		WebElement emailInput = driver.findElement(By.id("Email"));
		
//		//Clear and Send Keys to Input Box
//		emailInput.clear(); // Clear Default Text
//		emailInput.sendKeys("admin123@gmail.com");
		
		//Capturing Text from Input Box
		System.out.println("Result from getAttribute() Method: "+emailInput.getAttribute("id"));
		System.out.println("Result from getText() Method: "+emailInput.getText());
		
		//Login Button
		WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
		System.out.println("Result from getText() Method: "+ loginBtn.getText());
		System.out.println("Result from getAttribute() Method: "+ loginBtn.getAttribute("type"));
		
		//Get Title
		String title = driver.findElement(By.xpath("//div[@class='page-title']//h1")).getText();
		System.out.println("Title of Page: " +title);
		
		driver.close();
	}

}
