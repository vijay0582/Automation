package test;

import java.util.Iterator;
import java.util.Set;

import org.bouncycastle.util.test.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	
	    driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
	    driver.manage().window().maximize();
	    String parentid=driver.getWindowHandle();
	    		System.out.println(parentid);
	    	WebElement	Btn= driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
	    	Btn.click();
	    	Set<String>allWindows= driver.getWindowHandles();
	    	for(String s:allWindows) {
	    		if(parentid.equals(s)) {
	    			driver.switchTo().window(s);
	    			break;
	    		}
	    	}
	    WebElement firstName=driver.findElement(By.xpath("//input[@id='firstName']"));
	    firstName.sendKeys("Automation");
	    driver.close();
	    driver.switchTo().window(parentid);
	   WebElement name=   driver.findElement(By.xpath("//input[@id='name']"));
	   name.sendKeys("Test Automation");
	}

}
