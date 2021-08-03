package mypackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Date_pickerdropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='dob']")).click();

		Select month_dropdown = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month_dropdown.selectByVisibleText("Oct");

		Select year_dropdown = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year_dropdown.selectByVisibleText("2021");

		String date = "15";

		List<WebElement> allDates = driver.findElements(By.xpath("//a[@class='ui-state-default']"));

		for (WebElement selectDate : allDates) {
			String actualDate = selectDate.getText();

			if (actualDate.equals(date)) {
				selectDate.click();
				break;
			}
		}
	}

}
