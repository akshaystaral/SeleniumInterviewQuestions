package mypackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleJquerydropdown {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();

		driver.findElement(By.id("justAnInputBox")).click();

		//selectChoiceValue(driver,"all");
		selectChoiceValue(driver,"choice 1");
	}

	public static void selectChoiceValue(WebDriver driver, String... value) {
		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		
		if(!value[0].equalsIgnoreCase("all"))
		{
			for(WebElement item : choiceList)
			{
				String textValue = item.getText();
				
				for(String val : value)
				{
					if(textValue.equals(val))
					{
						item.click();
						break;
					}
				}
			}
		}
		else {
			for(WebElement item : choiceList)
			{
				item.click();
			}
		}
	}

}
