package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropdown {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		WebElement noOfEmployees = driver.findElement(By.name("NoOfEmployees"));
		selectOptionfromDropdown(noOfEmployees, "16 - 20");

		WebElement industry = driver.findElement(By.name("Industry"));
		selectOptionfromDropdown(industry, "Aerospace");

		WebElement country = driver.findElement(By.name("Country"));
		selectOptionfromDropdown(country, "Albania");
		
		driver.close();

	}

	public static void selectOptionfromDropdown(WebElement element, String value) {

		Select drp = new Select(element);

		List<WebElement> alloptions = drp.getOptions();

		for (WebElement options : alloptions) {
			if (options.getText().equals(value)) {
				options.click();
				break;
			}
		}

	}

}
