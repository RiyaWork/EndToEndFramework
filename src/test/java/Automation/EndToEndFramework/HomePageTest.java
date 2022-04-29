package Automation.EndToEndFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import objectRepository.LandingPage;
import objectRepository.LoginPage;
import resources.Base;

public class HomePageTest extends Base {
    
	public WebDriver driver;
	LandingPage lp; //global variable
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeClass
	public void initialize() throws IOException {
		driver=initializeDriver();	
		log.info("Driver is initialized");
	}
	
	@Test(dataProvider="getData")
	public void basePageNabigation(String username, String password) {
		String url=prop.getProperty("url");
		driver.get(url);
		log.info("Navigated to Landing Page");
		lp = new LandingPage(driver);
		if(lp.isNoThanksPopupPresent().size()==1) {
			log.info("Popup appears");
			lp.isNoThanksPopupPresent().get(0).click();
		}
		
		//compare the text on the browser with the expected text provided by client
		Assert.assertEquals(lp.getFeaturedCourses().getText(),"FEATURED COURSES");
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		LoginPage loginPage=lp.clickLoginIcon();
		loginPage.getEmailAddress().sendKeys(username);
		loginPage.getPassword().sendKeys(password);
		loginPage.getLoginButton().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[2][2];
		obj[0][0]="abc@qw.com";
		obj[0][1]="12334";
		obj[1][0]="ndd";
		obj[1][1]="nzkz";
		return obj;
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
