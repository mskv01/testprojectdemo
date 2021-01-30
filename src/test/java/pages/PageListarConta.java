package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import factories.ActionFactory;
import helpers.Message;

public class PageListarConta extends ActionFactory{

	public PageListarConta(WebDriver driver) {
		super(driver);
	}
	
	public PageAlterarConta acessarAlterarConta(int index) {
			click(findElements(By.className("glyphicon-edit"), 30).get(index));
			return new PageAlterarConta(driver());
	}
	public void excluirConta(int index) {
		click(findElements(By.className("glyphicon-remove-circle"), 30).get(index));
		existsElement(
				By.xpath("//div[contains(text(),'" + Message.ContaRemovidaComSucesso + "')]"),
				"Não foi apresentada a mensagem de Conta Removida com sucesso!",
				30
			);
	}
}
