package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_email")
	private WebElement emailAddress;
	
	@FindBy(id = "user_password")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Log In']")
	private WebElement logIN;
	
	@FindBy(css = ".alert-danger")
	private WebElement alertMessage;
	
	public WebElement getEmailAddress() {
		return emailAddress;
	}

	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getLoginButton() {
		return logIN;
	}
	
	public String getAlertMessage() {
		return alertMessage.getText();
	}
}
