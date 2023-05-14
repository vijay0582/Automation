package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vusepracticle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	
	    driver.get("https://www.saucedemo.com/");
	    driver.manage().window().maximize();
	    
	    
	    
	    WebElement Dropdown=  driver.findElement(By.xpath("//select[id='gender']"));
	    Select s= new Select(Dropdown);
	    s.selectByVisibleText("Male");

	}

}
