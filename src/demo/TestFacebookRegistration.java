package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestFacebookRegistration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//open browser
		System.setProperty("webdriver.chrome.driver","/home/arti/Downloads/chromedriver");
		WebDriver  driver=new  ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("xettrimamtakhadka@gmail.com ");
		
	
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("%$#@!Mamta2017");
		
		//for clicking the button 
		//driver.findElement(By.xpath("//input[@id='u_0_2']")).click();
		
		//for drop down 
		
		//Select seli=new Select(driver.findElement(By.xpath("//select[@id='day']")));
		//seli.selectByIndex(5);
		
		
		//another method
		//seli.selectByValue("2");
		//next method 
		//seli.deselectByVisibleText("2");
		
		
		//This  will click the  create page and 
		driver.findElement(By.xpath("//a[@href='/pages/create/?ref_type=registration_form']")).click();
		driver.navigate().back();
		
		driver.quit();
		
	}

}
