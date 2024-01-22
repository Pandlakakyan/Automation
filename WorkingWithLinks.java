package org.Links;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
/* In this file, I have written a sciript to find the count of a links in a webpage, footer section and column separately. 
Also, I have opened each of the column links in a separate browser window and navigated to each of the windows to grab the title.*/

public class WorkingWithLinks {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\cd\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// To get the count of number of links on the webpage
		
		int Count = driver.findElements(By.tagName("a")).size();
		System.out.println(Count);
		
		// To get the count of number of links displayed on the footer section of the webpage.
		WebElement footerelements = driver.findElement(By.id("gf-BIG"));
		int FooterElements = footerelements.findElements(By.tagName("a")).size();
		System.out.println(FooterElements);
		
		//To get the number of links in first column (Discount Coupons)
		WebElement CoulumnDriver = driver.findElement(By.xpath("//tbody/tr/td/ul"));
		int ColumnElements = CoulumnDriver.findElements(By.tagName("a")).size();
		System.out.println(ColumnElements);
		
		// Clicking on each links in the column and checking if it is opening or not
		
		for(int i = 1;i<ColumnElements;i++) {
		String key = Keys.chord(Keys.CONTROL, Keys.ENTER);
		CoulumnDriver.findElements(By.tagName("a")).get(i).sendKeys(key);
		Thread.sleep(5000L);
		}
		
		// Switching to opened tabs and get the titles
		
		Set <String> tabs = driver.getWindowHandles();
		Iterator <String> It = tabs.iterator();
		
		while(It.hasNext()) {
			driver.switchTo().window(It.next());
			System.out.println(driver.getTitle());
		}
		
	}
}
