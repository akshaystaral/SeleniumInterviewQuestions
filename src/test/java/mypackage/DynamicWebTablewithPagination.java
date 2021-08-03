package mypackage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.PhantomJsDriverManager;

public class DynamicWebTablewithPagination {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.opencart.com/admin/");
		driver.manage().window().maximize();

		WebElement username = driver.findElement(By.id("input-username"));
		username.clear();
		username.sendKeys("demo");

		WebElement password = driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("demo");

		driver.findElement(By.xpath("//button[@type='submit']")).submit();

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); if
		 * (wait.until(ExpectedConditions.alertIsPresent()) == null) {
		 * driver.switchTo().alert().accept(); }
		 * 
		 * else { System.out.println("Not Present"); }
		 */

		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();

		// Find total number of records
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();

		int total_page = Integer.valueOf(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
		System.out.println("Total Number of Pages: " + total_page);

		for (int p = 1; p <= 5; p++) {

			WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
			System.out.println("Active Page : " + active_page.getText());
			active_page.click();

			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr"))
					.size();
			System.out.println("Number of Rows: " + rows);

			// 3) Read all the number of pages
			for (int r = 1; r <= rows; r++) {
				String order_id = driver
						.findElement(By.xpath(
								"//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[2]"))
						.getText();
				String customer_name = driver
						.findElement(By.xpath(
								"//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[3]"))
						.getText();
				String status = driver
						.findElement(By.xpath(
								"//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[4]"))
						.getText();
				System.out.println(order_id + " " + customer_name + " " + status);
			}

			String page_number = Integer.toString(p + 1);
			//// ul[@class='pagination']//li//a[text()='4']
			driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='" + page_number + "']")).click();
		}
	}

}
