package de.alain.PageAndHTMLControl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderProduct extends Base {

	@FindBy(xpath = "//ul[@class='top-menu']//li[4]")
	private WebElement produktKategorie;

	@FindBy(xpath = "//a[contains(text(),'Blue Jeans')]")
	private WebElement blueJeans;

	@FindBy(xpath = "//span[@class='price-value-36']")
	private WebElement priceBlueJeans;

	@FindBy(id = "addtocart_36_EnteredQuantity")
	private WebElement quantityBlueJeans;

	@FindBy(id = "add-to-cart-button-36")
	private WebElement addToCartBlueJeans;

	@FindBy(xpath = "//p[@class='content']")
	private WebElement IsaddToCartBlueJeansMessageVisible;

	public OrderProduct(WebDriver driver) {
		super(driver);

	}

	public void productChoise() {
		click(produktKategorie, 20);
	}

	public void navigateToBluejeans() {
		click(blueJeans, 10);
	}

	public String priceBlueJeans() {
		return selectgetText(priceBlueJeans, 10);
	}

	public void typeMengeBluejeans(String InputText) {
		type(quantityBlueJeans, 10, InputText);
	}

	public void addToCartButton() {
		click(addToCartBlueJeans, 10);
	}

	public String IsBlueJeansAddToCart() {
		return selectgetText(IsaddToCartBlueJeansMessageVisible, 20);
	}
}
