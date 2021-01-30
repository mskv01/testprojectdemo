package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factories.ActionFactory;

public class PageHome extends ActionFactory {

	public PageHome(WebDriver driver) {
		super(driver);
	
	}

	public PageAdicionarConta acessarAdicionarConta() {
		click(By.xpath("//a[contains(text(),'Contas')]"), 30);
		click(By.xpath("//a[contains(text(),'Adicionar')]"), 30);
		return new PageAdicionarConta(driver());
	}
	
	public PageListarConta acessarListaDeContas() {
		click(By.xpath("//a[contains(text(),'Contas')]"), 30);
		click(By.xpath("//a[contains(text(),'Listar')]"), 30);
		existsElement(
			By.xpath("//th[contains(text(),'Conta')]"),
			"Erro ao acessar a página de listar contas",
			30
		);
		return new PageListarConta(driver());
	}

}
