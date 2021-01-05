package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factories.ActionFactory;

public class PageCadastro extends ActionFactory {

	public PageCadastro(WebDriver driver) {
		super(driver);
	}

	public void cadastrarUsuario(String nome, String email, String senha) {
		sendKeys(By.id("nome"), nome, 30);
		sendKeys(By.id("email"), email, 30);
		sendKeys(By.id("senha"), senha, 30);
		click(By.xpath("//input[@class='btn btn-primary']"), 30);
	}

}
