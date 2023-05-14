package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Vuseframework {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://www.vuse.com/gb/en/create-account");
	    driver.manage().window().maximize();
	   
	WebElement firstname =  driver.findElement(By.xpath("//autocomplete=[@id='120f9c6f-a3d4-4007-86c7-15b62202cf02']"));
	firstname.sendKeys("vijay");
	WebElement  lastname =  driver.findElement(By.xpath("//autocomplete=[@id='b2abb8a3-9182-49b5-8993-a9fabe50e928']"));
	lastname.sendKeys("deshwal");
	WebElement emailid=  driver.findElement(By.xpath(""));
	emailid.sendKeys("vijaydeshwal0582@gmail.com");
    WebElement dob = driver.findElement(By.xpath("//input[@id='28b6afea-f57f-42d0-85e7-2f1554225752']"));
    dob.click();
   WebElement  address= driver.findElement(By.xpath("//autocomplete[@id='f9870e1d-2a69-4c7a-a5b9-b58560e3052b']"));
   address.sendKeys("sultanpur");
   WebElement  phonenumber= driver.findElement(By.xpath("//autocomplete[@id='cec9a9d9-cd51-4716-8f8d-4b0b977940fe']"));
   phonenumber.sendKeys("9650000582");
   WebElement  password=  driver.findElement(By.xpath("//input[@id='0834be90-22d8-4a03-b4c9-422d486e4d94']"));
   password.sendKeys("vijay");
   WebElement  confoampassword =driver.findElement(By.xpath("//input[@id='4562cfb7-d9ae-496e-bf55-4ef54c81a2ac']"));
  confoampassword.sendKeys("vijay");
  WebElement   click= driver.findElement(By.xpath("//span[@class='checkbox-switchToggle-3tC right']"));
  click.click();
  WebElement   emailclick=driver.findElement(By.xpath("//span[@class='checkbox-switchToggle-3tC right']"));
  emailclick.click();
  WebElement smsclick=driver.findElement(By.xpath("//span[@class='checkbox-switchToggle-3tC right']"));
  smsclick.click();
  
  


	}

}
