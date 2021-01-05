package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factories.ActionFactory;
import helpers.Message;

public class PageLogin extends ActionFactory {

	public PageLogin(WebDriver driver) {
		super(driver);
	}

	public PageLogin accessLoginPage(String url) {
		navigate(url);
		existsElement(By.id("email"), "Erro ao acessar página de autenticação", 30);
		return this;
	}

	public void realizarLogin(String email, String senha) {
		sendKeys(By.id("email"), email, 30);
		sendKeys(By.id("senha"), senha, 30);
		click(By.xpath("//button[contains(text(),'Entrar')]"), 30);
	}

	public void verificarUsuarioAutenticadoComSucesso() {
		existsElement(By.xpath("//div[contains(text(),'Bem vindo, Fabio Alves!')]"),
				"ocorreu um erro ao realizar o login no sistema", 30);
	}

	public void validarLoginInvalido(String email, String senha) {
		sendKeys(By.id("email"), email, 30);
		sendKeys(By.id("senha"), senha, 30);
		click(By.xpath("//button[contains(text(),'Entrar')]"), 30);
		existsElement(
			By.xpath("//div[contains(text(),'" + Message.LoginInvalido + "')]"),
			"Não foi apresentada mensagem de login inválido",
			30
		);
	}
	public PageCadastro acessarCadastroUsuario() {
		click(By.xpath("//a[contains(text(),'Novo usuário?')]"), 30);
		return new PageCadastro(driver());
	}
	
}
