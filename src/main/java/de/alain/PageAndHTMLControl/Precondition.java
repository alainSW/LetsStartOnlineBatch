package de.alain.PageAndHTMLControl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Precondition extends Base {

	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginMainPage;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement button;

	@FindBy(xpath = "//a[contains(text(),'alain.samenwangueu@fincon.test')]")
	private WebElement einloggenMessageVisible;

	// Constructor
	public Precondition(WebDriver driver) {
		super(driver);
		visit("http://demowebshop.tricentis.com");
	}

	// Login Klick
	public void clickLogin() {
		click(loginMainPage, 10);
	}

	// Email eingeben
	public void typeEmail(String inputText) {
		type(email, 10, inputText);
	}

	// Email eingeben
	public void typePassword(String inputText) {
		type(password, 10, inputText);
	}

	// SubmitButton
	public void submitButton() {
		click(button, 10);
	}

	public Boolean isEmailVisible() {
		return elementsIsVisible(einloggenMessageVisible, 10);
	}
}
