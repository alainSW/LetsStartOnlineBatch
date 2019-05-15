package de.alain.PageAndHTMLControl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartCheckOut extends Base {

	@FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
	private WebElement shoppingCart;

	@FindBy(id = "termsofservice")
	private WebElement termsOfService;

	@FindBy(id = "checkout")
	private WebElement checkOut;

	public StartCheckOut(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void shoppingCartClick() {
		click(shoppingCart, 10);
	}

	public void termsOfServiceClick() {
		click(termsOfService, 10);
	}

	public void CheckOutClick() {
		click(checkOut, 10);
	}
}
