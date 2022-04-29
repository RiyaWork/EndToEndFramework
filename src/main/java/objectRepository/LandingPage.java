package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[href*='sign_in']")
	WebElement loginIcon;
	
	@FindBy(xpath="//button[text()='NO THANKS']")
	List<WebElement> noThanks;
	
	@FindBy(css="#content h2")
	WebElement featuredCoursesText;
	
	@FindBy(css=".nav.navbar-nav.navbar-right")
	WebElement navigationBar;
	
	@FindBy(xpath="//a[text()='Courses']")
	WebElement coursesLink;
	
	public List<WebElement> isNoThanksPopupPresent() {
		return noThanks;
	}
	
	public LoginPage clickLoginIcon() {
		loginIcon.click();
		return new LoginPage(driver);
	}
	
	public WebElement getFeaturedCourses() {
		return featuredCoursesText;
	}
	
	public WebElement getNavigationBar() {
		return navigationBar;
	}
	
	public WebElement getCoursesLink() {
		return coursesLink;
	}
}
