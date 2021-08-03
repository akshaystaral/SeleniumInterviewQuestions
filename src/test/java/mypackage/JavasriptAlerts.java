package mypackage;

//1) What is Java Script Alert?
//2) How To Handle Java Script Alerts?

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavasriptAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
//		//Alert Window wit OK Button
//		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
//		Thread.sleep(3000);
//		driver.switchTo().alert().accept();
//		
//		//Alert Window with Accept & Dismiss Button
//		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
//		Thread.sleep(3000);
//		//driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();
		
		//Alert window with input box
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		
		Alert alertWindow = driver.switchTo().alert();
		System.out.println("Message Displayed on ALert:" + alertWindow.getText());
		
		alertWindow.sendKeys("welcome");
		alertWindow.accept();
	}

}
