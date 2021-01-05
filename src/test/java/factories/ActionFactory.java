package factories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionFactory extends DriverFactory {

	public ActionFactory(WebDriver driver) {
		super(driver);
	}

	public WebElement findElement(By by, int timeout) {
		return new WebDriverWait(driver(), timeout).until(driver -> driver.findElement(by));
	}

	public List<WebElement> findElements(By by, int timeout) {
		return new WebDriverWait(driver(), timeout).until(driver -> driver.findElements(by));

	}

	public boolean existsElement(By by, int timeout) {
		try {
			findElement(by, timeout);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public void existsElement(By by, String text, int timeout) {
		if (!existsElement(by, timeout)) {
			Assert.fail(text);
		}
	}

	public void clear(By by, int timeout) {
		findElement(by, timeout).clear();
	}

	public void sendKeys(By by, String text, int timeout) {
		findElement(by, timeout).sendKeys(text);
	}

	public void sendKeys(WebElement element, String text) {
		if (!text.isEmpty()) {
			element.sendKeys(text);
		}
	}

	public void click(By by, int timeout) {
		findElement(by, timeout).click();
	}

	public void click(WebElement element) {
		element.click();
	}

	public void clickByIndex(By by, int index, int timeout) {
		click(findElements(by, timeout).get(index));
	}

	public void select(By by, String text, int timeout) {
		if (text.equals("") || text == null) {
			return;
		}
		new Select(findElement(by, timeout)).selectByVisibleText(text);
	}

	public void select(By by, int index, int timeout) {
		new Select(findElement(by, timeout)).selectByIndex(index);
	}

	public String returnText(By by, int timeout) {
		return findElement(by, timeout).getText();
	}

	public void verifyText(String expectedMessage, String currentMessage, String errorMessage) {
		assertEquals(errorMessage, expectedMessage, currentMessage);
	}

	public void containsText(String errorMessage, String expectedMessage, String currentMessage) {
		assertTrue(errorMessage, currentMessage.contains(expectedMessage));
	}

	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void changeTab(int index) {
		ArrayList<String> tabs = new ArrayList<String>(driver().getWindowHandles());
		driver().switchTo().window(tabs.get(index));
	}

}
