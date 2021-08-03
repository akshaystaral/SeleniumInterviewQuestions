package WebDriverCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTitle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/");
		// driver.getTitle();
		System.out.println(driver.getTitle());
		// Or can be written as
		String Title = driver.getTitle();
		System.out.println(Title);
		driver.quit();
	}

}
