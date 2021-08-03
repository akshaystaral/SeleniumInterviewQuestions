package mypackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigations {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/");
		
		//driver.get("https://www.amazon.in/");
		driver.navigate().to("https://www.amazon.in/");
		
		driver.navigate().back(); // Navigate back to the-internet.herokuapp.com
		driver.navigate().forward(); // Navigate to amazon
		
		driver.navigate().refresh(); // Refresh Page
		
		
		driver.quit();
	}

}
