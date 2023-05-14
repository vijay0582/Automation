package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascriptpopup {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	
	    driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
	    driver.manage().window().maximize();
	   WebElement Btn= driver.findElement(By.xpath("//button[@id='promptBox']"));
	   Btn.click();
	  Alert a= driver.switchTo().alert();
	  String popupvalue=a.getText();
	  System.out.println("popUpValue");
	  a.sendKeys ("Automation");
	  a.accept();
	  

	}

}
