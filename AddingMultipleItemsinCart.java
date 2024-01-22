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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingMultipleItemsinCart {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		 Thread.sleep(3000);
		 
		 // Getting the list of vegetables needed in an array as a string.
		 String[] itemsNeededList = {"Beetroot","Brocolli","Carrot","Beans","Carrot"};
		//Taking the vegetables that are displayed in the website as a list.
		 List<WebElement> itemsDisplayed = driver.findElements(By.cssSelector("h4.product-name"));
		//Using for loop we are iterating over the vegetables and comparing with the list of items we needed.
		 for(int i = 0;i<itemsDisplayed.size();i++) {  
			 // Brocolli - 1kg Splitting the text by "-" by using split method
			 String[] product = itemsDisplayed.get(i).getText().split("-");// Brocolli 1kg
			 String formattedName = product[0].trim();
			 
			 // Converting the array into array list.
			 List itemsNeeded1 = Arrays.asList(itemsNeededList);
			 if(itemsNeeded1.contains(formattedName)) {
			 	 System.out.print(formattedName);
			 	 driver.findElements(By.xpath("// div [@class = 'product-action']/button")).get(i).click();
			 }
			 
			 
		 }

	}
}



