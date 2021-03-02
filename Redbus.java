package week3.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Redbus {

	public static void main(String[] args) throws InterruptedException {
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
		
		WebElement source = driver.findElement(By.xpath("//label[text()='FROM']"));
		
		source.clear();
		
		source.sendKeys("Koyambedu, Chennai",Keys.TAB);
		
		Thread.sleep(2000);
		
		WebElement dest = driver.findElement(By.xpath("//label[text()='TO']"));
		
		dest.clear();
		
		dest.sendKeys("Madurai (All Locations)",Keys.TAB);
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("onward_cal")).click(); 
		driver.findElement(By.xpath("//td[@class='past day']/following-sibling::td[1]")).click();
		
		driver.findElement(By.xpath("//button[text()='Search Buses']")).click(); 
		
		Thread.sleep(2000);
		
		System.out.println("Date selected");
		
		//td[@class='past day']/following-sibling::td[1]
		
		
	}

}
