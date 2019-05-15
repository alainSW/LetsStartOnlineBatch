package de.alain.PageAndHTMLControl;

import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	public static WebDriver driver;

	public Base(WebDriver driver) {
		Base.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void visit(String url) {
		try {
			driver.get(url);
		} catch (WebDriverException wde) {
			System.out.println(wde);
			fail();
		}
	}

	public void click(WebElement element, int timeout) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (WebDriverException wde) {
			System.out.println(wde);
			fail();
		}
	}

	public void type(WebElement element, int timeout, String inputText) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
			element.clear();
			element.sendKeys(inputText);
		} catch (WebDriverException wde) {
			System.out.println(wde);
			fail();
		}
	}

	public void waitForElementToBeVisible(WebElement element, int timeout) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));

		} catch (WebDriverException wde) {
			System.out.println(wde);
			fail();
		}
	}

	public String selectgetText(WebElement element, int timeout) {
		String text = "";
		try {
			text = new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element)).getText();
			System.out.println(text);
		} catch (WebDriverException wde) {
			return "kein Text";
		}
		return text;
	}

	public void select(WebElement element, int timeout, String visibleText) {
		waitForElementToBeVisible(element, timeout);
		Select select = new Select(element);
		try {
			select.selectByVisibleText(visibleText);

		} catch (WebDriverException wde) {
			System.out.println(wde);
			fail();
		}
	}

	public boolean elementsIsVisible(WebElement element, int timeout) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));

		} catch (WebDriverException wde) {
			fail();

			return false;
		}
		return true;
	}

}
