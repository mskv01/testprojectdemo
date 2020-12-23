package testprojectdemo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Teste {

	@Test
	public void test1() {
		// Initialize browser
		WebDriverManager.chromedriver().driverVersion(Integer.toString(87)).setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		// Open Google
		driver.get("http://www.globo.com");

		driver.findElement(By.xpath("//span[contains(text(), 'g1')]")).click();

		// Close browser
		driver.quit();
	}
}
