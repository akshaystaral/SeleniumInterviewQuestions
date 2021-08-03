package WebDriverCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetCurrent {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/");
		// driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());

		String CurrentUrl = driver.getCurrentUrl();
		System.out.println(CurrentUrl);

		driver.quit();
	}

}
