package mypackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();

		String year = "2021";
		String month = "July";
		String day = "10";

		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();

		while (true) {
			String month_year = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			String arr[] = month_year.split(" ");
			String mon = arr[0];
			String yr = arr[1];

			if (mon.equalsIgnoreCase(month) && yr.equals(year))
				break;
			else
				driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
		}

		List<WebElement> allDates = driver
				.findElements(By.xpath("//table[@class='rb-monthTable first last']//tbody//tr//td[text()='10']"));

		for (WebElement ele : allDates) {
			String date = ele.getText();
			if (date.equalsIgnoreCase(day)) {
				ele.click();
				break;
			}
		}
		String selectedDate = driver.findElement(By.id("onward_cal")).getAttribute("data-caleng");
		System.out.println("Selected Date is : " + selectedDate);
	}

}
