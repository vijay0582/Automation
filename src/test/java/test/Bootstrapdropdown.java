package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bootstrapdropdown {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	
	    driver.get("https://www.selenium practice");
	    driver.manage().window().maximize();
	    WebElement DropdownBtn=  driver.findElement(By.xpath("//button[id='menu1']"));
	    DropdownBtn.click();
	 List<WebElement> dropDownList = driver.findElements(By.xpath("//u1[@class='dropdown-menu']/Li/a"));
	   for (WebElement ele:dropDownList) {
		   String optionValue=ele.getText();
		   System.out.println();
		   if(optionValue.equals("CSS")) {
			  
			   Thread.sleep(3000);
			   ele.click();
		   }
	   }
	}

}
