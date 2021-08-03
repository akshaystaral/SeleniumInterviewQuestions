package mypackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouserightClickaction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo/input.html");
		driver.manage().window().maximize();

		WebElement button = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

		Actions act = new Actions(driver);

		act.contextClick(button).build().perform();

		driver.close();
	}

}
