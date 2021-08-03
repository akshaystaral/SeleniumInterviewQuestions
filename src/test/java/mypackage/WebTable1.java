package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();

		// Count Rows
		int rows = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr")).size();
		System.out.println("Number of Rows: " + rows);

		// Count Columns
		int columns = driver.findElements(By.xpath("//table[@class='data-list']/thead/tr/th")).size();
		System.out.println("Number of Colums: " + columns);

		// Retrieve Specific row and column
		String value = driver.findElement(By.xpath("//table[@class='data-list']//tr[2]/td[1]")).getText();
		System.out.println("The Value is : " + value);

		/*
		 * // Retrieve all data from table System.out.println();
		 * System.out.println("Data From the Table"); for (int r = 1; r <= rows; r++) {
		 * for (int c = 1; c <= columns; c++) { String data =
		 * driver.findElement(By.xpath("//table[@class='data-list']//tr[" + r + "]/td["
		 * + c + "]")) .getText(); System.out.print(data + " "); } System.out.println();
		 * }
		 */

		// Print Release date and version
		for (int r = 1; r <= rows; r++) {
			String language = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr[" + r + "]/td[1]"))
					.getText();

			if (language.equals("Java")) {
				String versionno = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr[" + r + "]/td[2]"))
						.getText();
				String releaseDate = driver
						.findElement(By.xpath("//table[@class='data-list']/tbody/tr[" + r + "]/td[3]")).getText();
				System.out.println(language + "    " + versionno + "    " + releaseDate);
			}
		}

		driver.quit();

	}

}
