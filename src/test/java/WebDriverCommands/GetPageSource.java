package WebDriverCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetPageSource {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/");
		// driver.getPageSource();
		System.out.println(driver.getPageSource());

		// Or can be written as
		String PageSource = driver.getPageSource();
		System.out.println(PageSource);

		driver.quit();
	}

}
