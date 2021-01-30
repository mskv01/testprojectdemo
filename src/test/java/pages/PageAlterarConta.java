package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factories.ActionFactory;
import helpers.DateUtil;
import helpers.Message;

public class PageAlterarConta extends ActionFactory{

	public PageAlterarConta(WebDriver driver) {
		super(driver);
	}
	public void alterarConta (String conta) {
		clear(By.id("nome"), 30);
		sendKeys(By.id("nome"), conta+ DateUtil.retornaDataHora(), 30);
		click(By.xpath("//button[contains(text(),'Salvar')]"), 30);
		existsElement(
			By.xpath("//div[contains(text(),'" + Message.ContaAlteradaComSucesso + "')]"),
			"Não foi apresentada a mensagem de Conta alterada com sucesso!",
			30
		);
		
		
	}

	public void validarCamposObrigatorios() {
		clear(By.id("nome"), 30);
		click(By.xpath("//button[contains(text(),'Salvar')]"), 30);
		existsElement(
			By.xpath("//div[contains(text(),'" + Message.ContaObrigatorio + "')]"),
			"Não foi apresentada a mensagem de Informe o nome da conta",
			30
		);
	}
}
