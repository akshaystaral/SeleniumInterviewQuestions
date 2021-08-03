package mypackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();

		// Locate all Links
		List<WebElement> links = driver.findElements(By.tagName("a"));

		int brokenLinks = 0;

		for (WebElement element : links) {
			String url = element.getAttribute("href");

			if (url == null || url.isEmpty()) {
				System.out.println("URL is Empty");
				continue;
			}

			URL link = new URL(url);
			try {
				HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
				httpconn.connect();
				if (httpconn.getResponseCode() >= 400) {
					System.out.println(httpconn.getResponseCode() + url + " " + "is" + " broken Link");
					brokenLinks++;
				} else {
					System.out.println(httpconn.getResponseCode() + url + " is" + " Normal Link");
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("Numebr of Broken Links " + brokenLinks);
		driver.quit();
	}

}
