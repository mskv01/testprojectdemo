package manterlogin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import factories.DriverFactory;
import pages.PageLogin;

public class Test_ManterLogin_RealizarLogin {
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
	public void realizarLogin() {
		// Open Google
		login.accessLoginPage("https://seubarriga.wcaquino.me/login")
		.realizarLogin("fabioaraujo.alves@email.com","123456");
	}

	@After
	public void tearDown() {
		// Close browser
		driver.closeDriver();
	}
}
