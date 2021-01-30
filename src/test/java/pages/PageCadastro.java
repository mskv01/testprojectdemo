package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factories.ActionFactory;
import helpers.Message;

public class PageCadastro extends ActionFactory {

	public PageCadastro(WebDriver driver) {
		super(driver);
	}

	public PageCadastro cadastrarUsuario(String nome, String email, String senha) {
		sendKeys(By.id("nome"), nome, 30);
		sendKeys(By.id("email"), email, 30);
		sendKeys(By.id("senha"), senha, 30);
		click(By.xpath("//input[@class='btn btn-primary']"), 30);
		return this;
	}
	
	public void verificarUsuarioCadastradoComSucesso() {
		existsElement(
				By.xpath("//div[contains(text(),'" + Message.UsuarioCadastrado + "')]"),
				"Ocorreu um erro ao realizar o cadastro do usu�rio",
				30
				);	
	}
	
	public void validarCamposObrigatorios() {
		click(By.xpath("//input[@value='Cadastrar']"), 30);
		existsElement(
			By.xpath("//div[contains(text(),'Nome � um " + Message.CampoObrigorio + "')]"),
			"N�o foi apresentada mensagem de nome obrigat�rio",
			30
		);
		existsElement(
			By.xpath("//div[contains(text(),'Email � um " + Message.CampoObrigorio + "')]"),
			"N�o foi apresentada mensagem de email obrigat�rio",
			30
		);
		existsElement(
			By.xpath("//div[contains(text(),'Senha � um " + Message.CampoObrigorio + "')]"),
			"N�o foi apresentada mensagem de senha obrigat�ria",
			30
		);
	}
	public void validarRegistroDuplicado(String nome, String email, String senha) {
		sendKeys(By.id("nome"), nome, 30);
		sendKeys(By.id("email"), email, 30);
		sendKeys(By.id("senha"), senha, 30);
		click(By.xpath("//input[@value='Cadastrar']"), 30);
		existsElement(
				By.xpath("//div[contains(text(),'" + Message.EmailJaUtilizado + "')]"),
				"N�o foi apresentada mensagem de registro duplicado",
				30
			);
			
	}
}
