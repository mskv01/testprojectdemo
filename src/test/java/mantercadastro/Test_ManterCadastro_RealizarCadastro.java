package mantercadastro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import factories.DriverFactory;
import helpers.DateUtil;
import pages.PageLogin;

public class Test_ManterCadastro_RealizarCadastro {
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
	public void realizarCadastro() {
		// Open Google
		login.accessLoginPage("https://seubarriga.wcaquino.me/login")
		.acessarCadastroUsuario().cadastrarUsuario("coco", "fabioaraujo.alves@email.com"+DateUtil.retornaDataHora(), "123456").verificarUsuarioCadastradoComSucesso();
	}
	@After
	public void tearDown() {
		// Close browser
		driver.closeDriver();
	}

}
