package week3.day2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Redbus {
	
	

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		
		DesiredCapabilities cap = new DesiredCapabilities();         
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);                  
		ChromeOptions options = new ChromeOptions();         
		options.addArguments("--disable-notifications");                  
		options.merge(cap);         
		ChromeDriver driver=new  ChromeDriver(options);
		
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement src = driver.findElement(By.xpath("//input[@id='src']"));
		
		src.clear();
		
		src.sendKeys("Koyambedu, Chennai");
		
		Thread.sleep(4000);
		
		src.sendKeys(Keys.TAB);
		
		
		WebElement dest = driver.findElement(By.xpath("//input[@id='dest']"));
		
		dest.clear();
		
		dest.sendKeys("Madurai (All Locations)");
		
		Thread.sleep(2000);
		
		dest.sendKeys(Keys.TAB);
		
		driver.findElement(By.id("onward_cal")).click(); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@class='past day']/following-sibling::td[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@id='search_btn']")).click(); 
		
		Thread.sleep(30000);
		
		System.out.println("Date selected");
		
		
		String bus=driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText(); 
		Thread.sleep(2000);
		
		System.out.println("No of bus found is: "+ bus);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		
		File target = new File ("E://Selenium//Day6-Feb28,2021/Redbus.png");
		
		FileUtils.copyFile(source, target);
		
		
		
	}

}
