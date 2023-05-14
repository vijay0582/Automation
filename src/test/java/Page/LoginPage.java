package Page;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.compress.harmony.pack200.Segment.PassException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Helper.Base;

public class LoginPage extends Base {
	
public void user_enter_username_and_password() {
WebElement heading = driver.findElement(By.xpath(""));
String headingText=heading.getText();
assertEquals("vijay",headingText);
	WebElement  userName = driver.findElement(By.xpath("//input[@id='user-name']"));
	waitForExpectedElement(userName,10);
	userName.sendKeys("vijay");
	WebElement	password =  driver.findElement(By.xpath("//input[@id='password']"));
	password.sendKeys("Vijay@123");
	}
	public void click_on_login_button() {
		WebElement  loginBtn= driver.findElement(By.xpath("//input[@id='loginbutton')"));	
		loginBtn.click();
	
}
	public boolean validate_Success_login() {
	return	driver.findElement(By.xpath("//span[@class='tittle']")).isDisplayed();
		
	}
}
	


	


