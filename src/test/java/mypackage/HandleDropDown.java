package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stubWebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

		WebElement dropDaysList = driver.findElement(By.id("select-demo"));

		Select dropDay = new Select(dropDaysList);
		
		//dropDay.selectByVisibleText("Sunday");
		//dropDay.selectByValue("Monday");
		//dropDay.selectByIndex(3);
		
		List<WebElement> alloptions = dropDay.getOptions();
		
		for(WebElement options : alloptions)
		{
			if(options.getText().equals("Sunday"))
			{
				options.click();
				break;
			}
		}
		
		//driver.close();

	}

}
