package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBox {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();

		// 1) Select Specific Check box
		// driver.findElement(By.xpath("//input[@id='monday']")).click();

		// 2) Select all the Check box
		List<WebElement> daysList = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("Total Number of Days: " + daysList.size());

//		for (int i = 0; i <= daysList.size(); i++) {
//			daysList.get(i).click();
//		}

//		for(WebElement listele :daysList )
//		{
//			listele.click();
//		}

		// 3) Select Multiple Check boxes
		// Monday and Sunday
//		for (WebElement listele : daysList) {
//			String checkboxname = listele.getAttribute("id");
//			if (checkboxname.equals("monday") || checkboxname.equals("sunday")) {
//				listele.click();
//			}
//		}

		// 4) Select 2 checkboxes
		int totalCheckboxes = daysList.size();
//		for (int i = totalCheckboxes - 2; i < totalCheckboxes; i++) {
//			daysList.get(i).click();
//		}

		// 5) Select first 2 checkboxes
		for (int i = 0; i < totalCheckboxes -5 ; i++) {
			/*
			 * if(i<2) { daysList.get(i).click(); }
			 */
			 daysList.get(i).click();
		}

	}

}
