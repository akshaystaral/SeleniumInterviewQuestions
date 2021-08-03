package mypackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitwaitExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

		driver.findElement(By.xpath("//h3[text()='Selenium']")).click();

		driver.quit();
	}

}
