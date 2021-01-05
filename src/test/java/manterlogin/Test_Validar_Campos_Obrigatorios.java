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

public class Test_Validar_Campos_Obrigatorios {

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
	public void validarCamposObrigatorios() {

		// Open Google
		driver.get("https://seubarriga.wcaquino.me/login");

		driver.findElement(By.xpath("//button[contains(text(),'Entrar')]")).click();

		try {
			driver.findElement(By.xpath("//div[contains(text(),'Email é um campo obrigatório')]")).isDisplayed();

		} catch (Exception e) {
			Assert.fail("Não foi apresentada mensagem de email obrigatório");
		}

		try {
			driver.findElement(By.xpath("//div[contains(text(),'Senha é um campo obrigatório')]")).isDisplayed();

		} catch (Exception e) {
			Assert.fail("Não foi apresentada mensagem de senha obrigatória");
		}
		

	}

	@Test
	public void validarEmailObrigatorio() {
		// Open Google
		driver.get("https://seubarriga.wcaquino.me/login");

		driver.findElement(By.id("senha")).sendKeys("senha123456");

		driver.findElement(By.xpath("//button[contains(text(),'Entrar')]")).click();
		
		try {
			driver.findElement(By.xpath("//div[contains(text(),'Email é um campo obrigatório')]")).isDisplayed();

		} catch (Exception e) {
			Assert.fail("Não foi apresentada mensagem de email obrigatório");
		}
		

	}

	@Test
	public void validarSenhaObrigatoria() {
		// Open Google
		driver.get("https://seubarriga.wcaquino.me/login");

		driver.findElement(By.id("email")).sendKeys("teste@naocadastrado.com ");

		driver.findElement(By.xpath("//button[contains(text(),'Entrar')]")).click();

		try {
			driver.findElement(By.xpath("//div[contains(text(),'Senha é um campo obrigatório')]")).isDisplayed();

		} catch (Exception e) {
			Assert.fail("Não foi apresentada mensagem de senha obrigatória");
		}

	}

	@After
	public void tearDown() {
		// Close browser
		driver.quit();
	}

}
