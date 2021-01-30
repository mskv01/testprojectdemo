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

	public PageHome realizarLogin(String email, String senha) {
		sendKeys(By.id("email"), email, 30);
		sendKeys(By.id("senha"), senha, 30);
		click(By.xpath("//button[contains(text(),'Entrar')]"), 30);
		click(By.xpath("//a[contains(text(),'reset')]"), 30);
		return new PageHome(driver());
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
	
	public void validarCamposObrigatorios() {
		click(By.xpath("//button[contains(text(),'Entrar')]"), 30);
		existsElement(
			By.xpath("//div[contains(text(),'Email é um " + Message.CampoObrigorio + "')]"),
			"Não foi apresentada mensagem de email obrigatório",
			30
		);
		existsElement(
			By.xpath("//div[contains(text(),'Senha é um " + Message.CampoObrigorio + "')]"),
			"Não foi apresentada mensagem de senha obrigatória",
			30
		);
	}
	public void validarEmailObrigatorio() {
		sendKeys(By.id("senha"),"senha123456", 30);
		click(By.xpath("//button[contains(text(),'Entrar')]"), 30);
		existsElement(
			By.xpath("//div[contains(text(),'Email é um " + Message.CampoObrigorio + "')]"),
			"Não foi apresentada mensagem de email obrigatório",
			30
		);
	}
	public void validarSenhaObrigatoria() {
		sendKeys(By.id("email"),"teste@naocadastrado.com", 30);
		click(By.xpath("//button[contains(text(),'Entrar')]"), 30);
		existsElement(
			By.xpath("//div[contains(text(),'Senha é um " + Message.CampoObrigorio + "')]"),
			"Não foi apresentada mensagem de senha obrigatória",
			30
		);
	}
}
