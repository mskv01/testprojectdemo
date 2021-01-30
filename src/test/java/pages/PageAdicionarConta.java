package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factories.ActionFactory;
import helpers.DateUtil;
import helpers.Message;

public class PageAdicionarConta extends ActionFactory {

	public PageAdicionarConta(WebDriver driver) {
		super(driver);
	}
	
	public void incluirConta (String conta) {
		sendKeys(By.id("nome"), conta+ DateUtil.retornaDataHora(), 30);
		click(By.xpath("//button[contains(text(),'Salvar')]"), 30);
		existsElement(
			By.xpath("//div[contains(text(),'" + Message.ContaAdicionadaComSucesso + "')]"),
			"Não foi apresentada a mensagem de Conta adicionada com sucesso!",
			30
		);
	}

	public void validarCamposObrigatorios() {
		click(By.xpath("//button[contains(text(),'Salvar')]"), 30);
		existsElement(
			By.xpath("//div[contains(text(),'" + Message.ContaObrigatorio + "')]"),
			"Não foi apresentada a mensagem de Informe o nome da conta",
			30
		);
	}
}

