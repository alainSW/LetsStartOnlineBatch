package de.alain.PageAndHTMLControl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerifikationIfSuccess extends Base {

	@FindBy(xpath = "//strong[contains(text(),'Your order has been successfully processed!')]")
	private WebElement verifikationOfSuccess;

	public VerifikationIfSuccess(WebDriver driver) {
		super(driver);

	}

	public String verifikationOfSuccess() {
		return selectgetText(verifikationOfSuccess, 10);
	}

}
