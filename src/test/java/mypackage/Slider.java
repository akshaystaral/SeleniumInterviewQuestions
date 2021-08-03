package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();

		WebElement minSlider = driver.findElement(By.xpath("//span[1]"));
		WebElement maxSlider = driver.findElement(By.xpath("//span[2]"));

		System.out.println("Location of Minimum Slider:" + minSlider.getLocation()); // (59, 250)
		System.out.println("Dimensions of Minimum Slider:" + minSlider.getSize()); // (21, 21)

		Actions act = new Actions(driver);
		act.dragAndDropBy(minSlider, 100, 0).perform();
		System.out.println("After movement Location of Minimum Slider:" + minSlider.getLocation());
		System.out.println("After movement Dimensions of Minimum Slider:" + minSlider.getSize());

		System.out.println("Location of Maximum Slider:" + maxSlider.getLocation()); // (612, 250)
		System.out.println("Dimensions of Maximum Slider:" + maxSlider.getSize()); // (22, 21)
	
		act.dragAndDropBy(maxSlider, -100, 0).perform();
		System.out.println("After movement Location of Maximum Slider:" + maxSlider.getLocation());
		System.out.println("After movement Dimensions of Maximum Slider:" + maxSlider.getSize());

		// driver.quit();
	}

}
