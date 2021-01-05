package manterlogin;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Realizar_Login {
	WebDriver driver;

	@Before
	public void inicialize() {
		// Initialize browser
		WebDriverManager.chromedriver().driverVersion(Integer.toString(87)).setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
	}

	@Test
	public void realizarLogin() {
		// Open Google
		driver.get("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.id("email")).sendKeys("fabioaraujo.alves@email.com");
		driver.findElement(By.id("senha")).sendKeys("123456");

		driver.findElement(By.xpath("//button[contains(text(),'Entrar')]")).click();
		try {
			driver.findElement(By.xpath("//div[contains(text(),'Bem vindo, Fabio Alves!')]")).isDisplayed();

		} catch (Exception e) {
			Assert.fail("ocorreu um erro ao realizar o login no sistema");
		}

	}

	@After
	public void tearDown() {
		// Close browser
		driver.quit();
	}
}
