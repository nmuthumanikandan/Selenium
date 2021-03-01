package week3.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxProgram {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new  ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testleaf.herokuapp.com/pages/checkbox.html");
		
		//Using Selected ()

		boolean selected = driver
				.findElementByXPath("(//label[text()='Confirm Selenium is checked']/following::input)[1]").isSelected();
		if (selected == true) {
			System.out.println("checkbox is checked");
		} else {
			System.out.println("checkbox is not checked");
		}
		
		//Find selected checkbox. Xpath to find Parent child
		List<WebElement> check =driver.findElements(By.xpath("//label[text()='DeSelect only checked']/following-sibling::input[2]"));
		
		boolean bval = false; // Create a variable which will have boolean value True/False
		bval = check.get(0).isSelected(); // Will return True if box is selected.
		
		if(bval == true) 
		{
		
			check.get(0).click();	  // If the first check box is selected by default,then it click again to uncheck
		System.out.println("I am selected - Unselected");
		
		System.out.println("**************************************");
		
		}
		
		List<WebElement> ListOfCheckBoxes =driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following-sibling::input"));
		
		System.out.println("Number of check boxes pesent are: "+ListOfCheckBoxes.size());
		 for(int i=0; i< ListOfCheckBoxes.size() ; i++) {
			   if(ListOfCheckBoxes.get(i).getAttribute("type").equalsIgnoreCase("Option 1")){
			    ListOfCheckBoxes.get(i).click();
			   }
			       }
	}

}
