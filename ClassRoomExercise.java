package week3.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoomExercise {

	public static void main(String[] args) throws InterruptedException { 
	
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new  ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		
		driver.get("https://erail.in/");
		
		WebElement fromStation= driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		
		fromStation.clear();
		
		fromStation.sendKeys("MDU");
		
		fromStation.sendKeys(Keys.TAB);
		
		fromStation.sendKeys(Keys.ENTER);
		
		WebElement toStation= driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		
		toStation.clear();
		
		toStation.sendKeys("MAS");
		
		toStation.sendKeys(Keys.TAB);
		
		toStation.sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		Thread.sleep(2000);
		
		List<WebElement> trainlist = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[1]/td[1]"));
		
		List<String> listTrainnames=new ArrayList<String>();
		
		for (int i = 1; i <= trainlist.size(); i++) {
			
			String trainame = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[1]/td[2]"));
			
			listTrainnames.add(trainame);
			
		}
		
		Set <String> setTrainnames= new HashSet<String>(listTrainnames);
		
		
		if (listTrainnames.size() == setTrainnames.size()) {
			
			System.out.println("no duplicates");
			
		} else {
			
			System.out.println("Duplicate trains");

		}
		}


}
