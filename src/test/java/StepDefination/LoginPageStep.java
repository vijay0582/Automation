package StepDefination;

import static org.junit.Assert.assertTrue;

import Helper.Base;
import Page.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStep extends Base {
	LoginPage login = new LoginPage();

	@Given("user launch site URL")
	public void user_launch_site_url() {
		setup();
	}

	@When("user enter username and password")
	public void user_enter_username_and_password() {
		login.user_enter_username_and_password();
	}

	@And("click on login button")
	public void click_on_login_button() {
		login.click_on_login_button();
	}

	@Then("Validate Success login")
	public void validate_success_login() {
		assertTrue(login.validate_Success_login());

	}
}
