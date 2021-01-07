package manterlogin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import factories.DriverFactory;
import pages.PageLogin;

public class Test_Validar_Campos_Obrigatorios {
	public DriverFactory driver;
	public PageLogin login;

	@Before
	public void inicialize() {
		// Initialize browser
		driver = new DriverFactory();
		driver.createDriver();
		login = new PageLogin(driver.driver());
	}

	@Test
	public void validarCamposObrigatorios() {
		// Open Google
		login.accessLoginPage("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.xpath("//button[contains(text(),'Entrar')]")).click();
	}

	@Test
	public void validarEmailObrigatorio() {
		login.accessLoginPage("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.id("senha")).sendKeys("senha123456");
		driver.findElement(By.xpath("//button[contains(text(),'Entrar')]")).click();

	}

	@Test
	public void validarSenhaObrigatoria() {
		login.accessLoginPage("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.id("email")).sendKeys("teste@naocadastrado.com ");
		driver.findElement(By.xpath("//button[contains(text(),'Entrar')]")).click();
	}

	@After
	public void tearDown() {
		// Close browser
		driver.closeDriver();
	}
}