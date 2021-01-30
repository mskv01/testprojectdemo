package mantercadastro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import factories.DriverFactory;
import pages.PageLogin;

public class Test_ManterCadastro_ValidarCamposObrigatorios {
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
		login.accessLoginPage("https://seubarriga.wcaquino.me/login")
		.acessarCadastroUsuario().validarCamposObrigatorios();
	}

	@After
	public void tearDown() {
		// Close browser
		driver.closeDriver();
	}

}
