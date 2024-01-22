package org.ticketbooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PassengerInfo extends Flight_Ticket {
	
	String driverpath = "C:\\chromedriver\\msedgedriver.exe";
	public WebDriver driver;
	@BeforeTest
	private void Beforestarting() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", driverpath);
	    driver = new EdgeDriver();
	}
	@Test
	private void Passengerdetails() {
		// TODO Auto-generated method stub
		driver.navigate().to("https://www.tripodeal.com/book?tid=62ef9e0108eb6e28170b39bc&did=62ef9e0108eb6e28170b39bc_d_21&rid=");
		driver.findElement(By.xpath("// input[@ id = 'email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("Phone")).sendKeys("98765412301");
		
		// Logic to handle the static dropdown
		WebElement dropdown = driver.findElement(By.id("title_ADT1"));
		Select stat = new Select(dropdown);
		stat.selectByIndex(1);
		
		driver.findElement(By.id("firstname_ADT1")).sendKeys("abc");
		
		// Selecting the DOB
		driver.findElement(By.id("dob_ADT1")).click();
		driver.findElement(By.xpath("// div [@class = 'caleran-ys-year-prev']")).click();
		driver.findElement(By.xpath("/html/body/div[14]/div[2]/div[2]/div[3]/div[2]")).click();
		driver.findElement(By.xpath("/html/body/div[14]/div[2]/div[2]/div[3]/div[8]")).click();
		driver.findElement(By.xpath("/html/body/div[14]/div[2]/div[2]/div[1]/div[2]/div[19]")).click();
	}
}
