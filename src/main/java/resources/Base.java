package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver; // public variable so that this variables can be accessed outside the class
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		// String browserName=System.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chromeheadless")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("headless");
			driver = new ChromeDriver(option);
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.edge.driver", "D:\\edgedriver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		// Implicit wait to avoid synchronization issues -- globally applicable
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		return driver;

	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(f, new File(destinationFile));
		return destinationFile;
	}
	
	
}
