package org.ticketbooking;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TimeBombSkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Flight_Ticket {
	String driverpath = "C:\\chromedriver\\msedgedriver.exe";
	public WebDriver driver;
	@BeforeTest
	private void Beforestarting() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", driverpath);
	    driver = new EdgeDriver();
	}  
	@Test
	private void HomepageValidations() {
		// TODO Auto-generated method stub
    driver.navigate().to("https://www.tripodeal.com/flight-deal?utm_source=bing_tpk&utm_medium=cpc&utm_campaign=bing_c_tpk&msclkid=58b1d21293da17e9d5a1b0fb7aeff5ab");
	String ActualTitle = driver.getTitle();
    String ExpectedTitle = "Flights, Cheap Flights, Discounted Flight Deals - TripOdeal.com";
	AssertJUnit.assertEquals(ActualTitle, ExpectedTitle);
	}
	@Test
    private void Plan() throws InterruptedException {
		// TODO Auto-generated method stub
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//*[@id ='returnDateRequiredNo']")).click();
	// Autosuggestive drop down
    WebElement Source = driver.findElement(By.id("origin"));
    Source.sendKeys("Madurai");
    Thread.sleep(1000);
    Source.sendKeys(Keys.ARROW_DOWN);
    Thread.sleep(1000);
    Source.sendKeys(Keys.ENTER);
    
    WebElement Destination = driver.findElement(By.name("destination"));
    Destination.sendKeys("Chennai");
    Thread.sleep(1000);
    Destination.sendKeys(Keys.ARROW_DOWN);
    Thread.sleep(1000);
    Destination.sendKeys(Keys.ENTER);
    // Logic to handle the calender
    driver.findElement(By.cssSelector("[class = 'col-6 col-sm-6 col-lg-6 mt-2 date-row']  [class = 'formRow'] [class = 'formRow--item'] [class = 'formRow--input-wrapper js-inputWrapper active'] [id = 'dateNew']")).click();
	try{
		while (! driver.findElement(By.cssSelector("[class = 'picker picker--opened picker--focused'] [class = 'picker__holder'] [class = 'picker__frame'] [class = 'picker__wrap'] [class = 'picker__box'] [class = 'picker__header'] [class = 'picker__month']")).getText().equals("December"))
	{
		driver.findElement(By.cssSelector("[class = 'picker picker--opened picker--focused'] [class = 'picker__holder'] [class = 'picker__frame'] [class = 'picker__wrap'] [class = 'picker__box'] [class = 'picker__header'] [class = 'picker__nav--next']")).click();
	}
	} catch (StaleElementReferenceException e) {
		while (! driver.findElement(By.cssSelector("[class = 'picker picker--opened picker--focused'] [class = 'picker__holder'] [class = 'picker__frame'] [class = 'picker__wrap'] [class = 'picker__box'] [class = 'picker__header'] [class = 'picker__month']")).getText().equals("December"))
		{
			driver.findElement(By.cssSelector("[class = 'picker picker--opened picker--focused'] [class = 'picker__holder'] [class = 'picker__frame'] [class = 'picker__wrap'] [class = 'picker__box'] [class = 'picker__header'] [class = 'picker__nav--next']")).click();
		}
	}
    driver.findElement(By.xpath("// div[@ id = 'dateNew_1672252200000']")).click();
    driver.findElement(By.xpath("// div [@ class = 'col-12 col-md-8 mt-3']/fieldset/div/label")).click();
    
   int i = 1;
   while (i <3) {
	   driver.findElement(By.xpath("//*[@id=\"Search_Flights\"]/div[3]/div[9]/div/div[2]/div[2]/div/span[2]/button/i")).click();
       i++; 
   }
  // Logic to handle static dropdown
  
  WebElement StaticDropdown = driver.findElement(By.xpath("// select[@ id ='classi']"));
  Select Dropdown = new Select(StaticDropdown);
  Dropdown.selectByIndex(1);
  
  driver.findElement(By.cssSelector("[class ='d-none d-sm-block'] [class='zmdi zmdi-hc-3x zmdi-swap-vertical-circle swapicon']")).click();
  driver.findElement(By.xpath("//div[@class = 'col-12 col-md-4 mt-3']/div/button")).click();
  }
    @Test
	private void coupon() throws InterruptedException{
	// TODO Auto-generated method stub
    		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    		WebElement Coupon =	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("// div[@ class ='p-2 pl-3']/div/div[2]/a")));
    		Coupon.click();
    		
    	   // Handling the alert box
    	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    	    WebDriverWait alert = new WebDriverWait(driver, Duration.ofSeconds(20));
    		if(alert.until(ExpectedConditions.alertIsPresent())== null) {
    			System.out.println("alert is not present");
    		} 
    		else {
    			driver.switchTo().alert();
        		driver.findElement(By.xpath("//div[@id ='modalLoadAny']/div/div/div[3]/a")).click();
    		} 
		
    		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    		WebElement Coupon_Message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='preloader_setup']/div/div[1]/div[8]/div/div/article/div/div/div[8]/div[3]")));
    		System.out.println("Coupon has been applied");
    }
   
