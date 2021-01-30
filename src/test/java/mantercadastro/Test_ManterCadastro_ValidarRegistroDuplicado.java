package mantercadastro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import factories.DriverFactory;
import pages.PageLogin;

public class Test_ManterCadastro_ValidarRegistroDuplicado {
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
	public void validarRegistroDuplicado() {
		// Open Google
		login.accessLoginPage("https://seubarriga.wcaquino.me/login")
		.acessarCadastroUsuario().validarRegistroDuplicado("Juca", "fabioaraujo.alves@email.com", "123456");
	}

	@After
	public void tearDown() {
		// Close browser
		driver.closeDriver();
	}

}
