package org.Amazon;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

/* Here, I have applied filters available in amazon website. 
Filters Added --->>> Get it by Tomorrow, selected smartphones from departments, Reviews : 4star & up, Price over 20000max and discount applied equals 10%
*/

public class AmazonFilters {
public static void main(String[] args) {
	System.setProperty("webdriver.edge.driver","C:\\cd\\msedgedriver.exe");
	 WebDriver driver = new EdgeDriver();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Adding Implicit wait 
	 driver.get("https://www.amazon.in/");
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung" + "\n"); 
	 driver.findElement(By.xpath("//li[@id=\"p_90/6741118031\"]/span/a/div/label/i")).click();
	 System.out.println(driver.findElement(By.xpath("//span [@class = 'a-size-base a-color-base a-text-bold']")).getText());
	 driver.findElement(By.linkText("Smartphones")).click();
	 driver.findElement(By.xpath("//i[@class='a-icon a-icon-star-medium a-star-medium-4']")).click();
	 System.out.println(driver.findElement(By.xpath("//div[@id ='p_72-title']/span")).getText());
	 driver.findElement(By.xpath("//li[@id ='p_36/1318507031']/span/a/span")).click();
	 System.out.println(driver.findElement(By.xpath("//li[@id ='p_36/1318507031']/span/a/span")).getText());
	 driver.findElement(By.xpath("//li [@id ='p_n_pct-off-with-tax/2665399031']/span/a/span")).click();
	 System.out.println(driver.findElement(By.xpath("//li [@id ='p_n_pct-off-with-tax/2665399031']/span/a/span")).getText());
}
}
