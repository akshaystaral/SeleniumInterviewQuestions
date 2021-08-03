package mypackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

		// getWindowHandle()
		String windowIdhandler = driver.getWindowHandle();
		//System.out.println("Window Id of 1'st window: " + windowIdhandler); // CDwindow-5A31FFD78F4CB5E2990B954EAC134771

		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click(); // Open Another Broswer window/tab

		// getWindowHandles()
		Set<String> windowIds = driver.getWindowHandles(); // Return Id's of multiple browser windows
		
		//First Method
		// Iterator Method
		/* Iterator<String> it = windowIds.iterator();

		String parentWindow = it.next();
		String childWindow = it.next();

		System.out.println("Parent Window ID: " + parentWindow);
		System.out.println("Child Window ID: " + childWindow); */
		
		//Second Method - Using ArrayList
		List<String> windowIdList = new ArrayList(windowIds); //Converting Set to List to extract values
		
	/*	String parentidList = windowIdList.get(0);
		String childidList = windowIdList.get(1);
		
		System.out.println("Parent Window ID: " + parentidList);
		System.out.println("Child Window ID: " + childidList);
			
		//How to Switch to Parent Window
		driver.switchTo().window(parentidList);
		System.out.println("Parent Window Title: " + driver.getTitle());
		
		driver.switchTo().window(childidList);
		System.out.println("Child Window Title: " + driver.getTitle()); */
		
		//For Each Loop
		for (String winId : windowIdList)
		{
			//System.out.println(winId);
			String title = driver.switchTo().window(winId).getTitle();
			System.out.println("Title of Page: " + title);
			if(title.equals("HR Management System | HR Management Software | OrangeHRM"))
			{
				driver.close();
			}
		}

		//driver.close(); // Close Single Window , where driver is currently pointing
		//driver.quit(); // Clsoe all Windows
	}

}
