package factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private WebDriver driver;

	public DriverFactory () {
		
	}
	
	
	public DriverFactory(WebDriver driver) {
		this.driver = driver;
	}

	public void navigate(String url) {
		driver.get(url);
	}

	public void createDriver() {
		// Initialize browser
		WebDriverManager.chromedriver().driverVersion(Integer.toString(87)).setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
	}

	public WebDriver driver() {
		return driver;
	}

	public void closeDriver() {
		driver.quit();
	}


	public WebElement findElement(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

}
