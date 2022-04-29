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
import org.testng.annotations.Test;
import objectRepository.CoursesPage;
import objectRepository.LandingPage;
import resources.Base;

public class CoursesPageTest extends Base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeClass
	public void initialize() throws IOException {
		driver=initializeDriver();	
		log.info("Driver is initialized");
	}
	
	@Test
	public void coursePageNavigation() {
		String application_url=prop.getProperty("url");
		driver.get(application_url);
		log.info("Navigated to Landing Page");
		LandingPage lp= new LandingPage(driver);
		if(lp.isNoThanksPopupPresent().size()==1) {
			log.info("Popup appears");
			lp.isNoThanksPopupPresent().get(0).click();
		}
		lp.getCoursesLink().click();
		log.info("Navigated to Courses Page");
		CoursesPage cp = new CoursesPage(driver);
        Assert.assertEquals(cp.getFeaturedCoursesTitle().getText(), "Featured Courses");		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
