package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusofWebElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

		WebElement searchStore = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		WebElement male = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female = driver.findElement(By.xpath("//input[@id='gender-female']"));

		System.out.println("Display Status of Search Box: " + searchStore.isDisplayed()); // true
		System.out.println("Display Status of Search Box: " + searchStore.isEnabled()); // true
		
		
		//isSelected() is used for Radio Buttons, Check box , drop down
		System.out.println("Maler Radio Buttons Selected Satus: " + male.isSelected()); // False
		System.out.println("Maler Radio Buttons Selected Satus: " + female.isSelected()); // False

		// Select Both Radion Buttons to make condition as True
		male.click();

		System.out.println("Male Radio Buttons Selected Satus: " + male.isSelected()); // true
		System.out.println("Feamale Radio Buttons Selected Satus: " + female.isSelected()); // False

		female.click();

		System.out.println("Male Radio Buttons Selected Satus: " + male.isSelected()); // False
		System.out.println("Feamale Radio Buttons Selected Satus: " + female.isSelected()); // true

		driver.quit();
	}

}
