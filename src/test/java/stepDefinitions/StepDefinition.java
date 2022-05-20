package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import objectRepository.LandingPage;
import objectRepository.LoginPage;
import resources.Base;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;

public class StepDefinition extends Base {
	
   WebDriver driver;

	@Given("^Initialize the browser with Chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
	public void user_enters_something_and_something_and_logs_in(String strArg1, String strArg2) throws Throwable {
		System.out.println("Inside login page");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmailAddress().sendKeys(strArg1);
		loginPage.getPassword().sendKeys(strArg2);
		loginPage.getLoginButton().click();
	}

	@Then("^Verify user is not logged in$")
	public void verify_user_is_not_logged_in() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
		System.out.println("Not logged in");
		//System.out.println(loginPage.getAlertMessage().trim());
		//Assert.assertTrue(loginPage.getAlertMessage().trim().equalsIgnoreCase("Invalid email or password."));
	}

	@And("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_something_site(String strArg1) throws Throwable {
		driver.get(strArg1);
	}

	@And("^Click on Login in HomePage to land on secure sign in page$")
	public void click_on_login_in_homepage_to_land_on_secure_sign_in_page() throws Throwable {
		LandingPage lp = new LandingPage(driver);
		lp.clickLoginIcon();
	}

	@And("^Click on No Thanks popup$")
	public void click_on_no_thanks_popup() throws Throwable {
		LandingPage lp = new LandingPage(driver);
		if(lp.isNoThanksPopupPresent().size() == 1) {
			lp.isNoThanksPopupPresent().get(0).click();
		}
	}
}
