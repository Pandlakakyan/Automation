package org.Cart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class adding_in_cart {
	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		  //Getting the displayed items as a list
		 List<WebElement> itemsDisplayed = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
		 //Using for loop and getting the text of instance and stroing in a variable
		 for(int i = 0;i<itemsDisplayed.size();i++) {
			 String currentProduct = itemsDisplayed.get(i).getText();
			 //Writing condition to check if the instance is matching with the needed vegetable
			 if (currentProduct.contains("Cucumber"))
			 {
				int j = 0;
				while(j<4) {
					// Loop for incrementing the KG
					driver.findElement(By.xpath("//a[@class  = 'increment']")).click();
					j++;
				 }
				// Adding the element to cart
				 driver.findElement(By.xpath("//button[text()  = 'ADD TO CART']")).click();
				 
			 }
		 }
}
}


