package de.alain.PageAndHTMLControl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerificationOfPrices extends Base {

	@FindBy(xpath = "//span[@class='product-price']")
	private WebElement getSubTotal;

	@FindBy(xpath = "//span[contains(text(),'10.00')]")
	private WebElement getShippingGroundPreis;

	@FindBy(xpath = "//strong[contains(text(),'35.00')]")
	private WebElement getTotalPreis;

	public VerificationOfPrices(WebDriver driver) {
		super(driver);
	}

	public String getSubTotalPreis() {
		return selectgetText(getSubTotal, 10);
	}

	public String getShippingGroundPreis() {
		return selectgetText(getShippingGroundPreis, 10);
	}

	public String getTotalPreis() {
		return selectgetText(getTotalPreis, 10);
	}

}
