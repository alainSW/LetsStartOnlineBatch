package de.alain.PageAndHTMLControl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Confirmation extends Base {

	@FindBy(xpath = "//input[@value='Confirm']")
	private WebElement confirmationButton;

	public Confirmation(WebDriver driver) {
		super(driver);

	}

	public void confirmationButtonClick() {
		click(confirmationButton, 10);
	}

}
