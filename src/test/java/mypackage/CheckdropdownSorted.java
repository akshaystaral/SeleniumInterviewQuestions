package mypackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckdropdownSorted {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();

		WebElement dropEle = driver.findElement(By.name("category_id"));
		Select dropSelect = new Select(dropEle);

		List<WebElement> options = dropSelect.getOptions();

		ArrayList originalList = new ArrayList();
		ArrayList tempList = new ArrayList();

		for (WebElement option : options) {
			originalList.add(option.getText());
			tempList.add(option.getText());
		}

		Collections.sort(tempList);

		System.out.println("Original List: " + originalList);
		System.out.println("Temooray List: " + tempList);

		if (originalList.equals(tempList)) {
			System.out.println("Drop dow in Sorted.");
		} else {
			System.out.println("Drop dow in Unsorted.");
		}

		driver.quit();
	}

}
