package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Helper.Base;

public class LoginPage extends Base {

	public void user_enter_username_and_password() {

		WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
		waitForExpectedElement(userName);
		userName.sendKeys("vijay");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Vijay@123");
	}

	public void click_on_login_button() {
		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginBtn.click();

	}

	public boolean validate_Success_login() {
		return driver.findElement(By.xpath("//span[@class='tittle']")).isDisplayed();

	}
}
