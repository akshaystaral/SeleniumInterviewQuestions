package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.monsterindia.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[@class='uprcse semi-bold']")).click();
		
		//using sendkeys()
		//driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("A:\\Resume\\manual-testing-resume-2.doc");
		
		//Using Robot class method
		driver.findElement(By.xpath("//input[@id='file-upload']")).click();
	}

}
