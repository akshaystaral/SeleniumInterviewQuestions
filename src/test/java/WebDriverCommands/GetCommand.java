package WebDriverCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetCommand {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new ChromeDriver();

		// Get Command
		driver.get("https://www.google.co.in/");

		// Or can be written as
		String URL = "https://www.bing.com/";
		driver.get(URL);

		driver.quit();

	}

}
