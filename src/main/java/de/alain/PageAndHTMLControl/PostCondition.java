package de.alain.PageAndHTMLControl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostCondition extends Base {

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement confirmationKaufbutton;

	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logOutButton;

	public PostCondition(WebDriver driver) {
		super(driver);
	}

	public void confirmationKaufbuttonClick() {
		click(confirmationKaufbutton, 10);
	}

	public void logOutButtonClick() {
		click(logOutButton, 10);
	}

}
