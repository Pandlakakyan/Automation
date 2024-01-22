//package org.Cart;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;

package org.Cart;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class AddingMultipleItemsinCart {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);// Implicit wait has been used in the program
		 
		 String[] itemsNeededList = {"Beetroot","Brocolli","Carrot","Beans","Carrot"};
		 List<WebElement> itemsDisplayed = driver.findElements(By.cssSelector("h4.product-name"));
		 for(int i = 0;i<itemsDisplayed.size();i++) {  
			 // Brocolli - 1kg Splitting the text by "-" by using split method
			 String[] product = itemsDisplayed.get(i).getText().split("-");// Brocolli 1kg
			 String formattedName = product[0].trim();
			 
			 // Converting the array into array list
			 List itemsNeeded1 = Arrays.asList(itemsNeededList);
			 if(itemsNeeded1.contains(formattedName)) {
			 	 System.out.print(formattedName);
			 	 driver.findElements(By.xpath("// div [@class = 'product-action']/button")).get(i).click();
			 }
		 }
		 
		 driver.findElement(By.xpath("//a[@class = 'cart-icon']")).click();
		 driver.findElement(By.xpath("//button[text()= 'PROCEED TO CHECKOUT']")).click();
		 driver.findElement(By.xpath("//input[@placeholder= 'Enter promo code']")).sendKeys("RahulShettyAcademy");
		 driver.findElement(By.xpath("//button [@class ='promoBtn']")).click();
		 System.out.println("driver.findElement(By.xpath(\"//span[text() = 'Invalid code ..!']\")).getText();");
		 driver.findElement(By.xpath("//button[text() = 'Place Order']")).click();

	}
}



