package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursesPage {

	public WebDriver driver;

	public CoursesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".courses-section .sec-title h2")
	WebElement featuredCoursesTitle;
	
	public WebElement getFeaturedCoursesTitle() {
		return featuredCoursesTitle;
	}

	
}
