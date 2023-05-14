package StepDefination;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.github.dockerjava.api.model.Driver;

import Helper.Base;
import Page.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginPageStep  extends Base {
	 LoginPage login= new LoginPage();
	static WebDriver driver ;

	@Given("user launch site URL")
	public void user_launch_site_url() {
	    
	}

	@When("user enter username and password")
	public void user_enter_username_and_password() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions  option = new ChromeOptions();
		driver =new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}
	

	@And("click on login button")
	public void click_on_login_button() {
		login.click_on_login_button();
	}

	@Then("Validate Success login")
	public void validate_success_login() {
		assertTrue(true);login.validate_Success_login();



	}}
