package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();	
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().maximize();
    WebElement username= driver.findElement(By.xpath("//input[@id='user-name']"));
    username.sendKeys("test");
    WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
   password.sendKeys("password");
   WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
   login.click();
	}}
