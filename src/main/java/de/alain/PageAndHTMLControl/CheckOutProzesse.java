package de.alain.PageAndHTMLControl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutProzesse extends Base {

	@FindBy(xpath = "//div[@id='billing-buttons-container']//input[@title='Continue']")
	private WebElement billingAdresseContinue;

	@FindBy(xpath = "//div[@id='shipping-buttons-container']//input[@title='Continue']")
	private WebElement shippingAdresseContinue;

	@FindBy(xpath = "//input[@id='shippingoption_0']")
	private WebElement shippingMethodeGround;

	@FindBy(xpath = "//div[@id='shipping-method-buttons-container']//input[@value='Continue']")
	private WebElement shippingMethodeGroundContinu;

	@FindBy(id = "paymentmethod_2")
	private WebElement paymentMethodsCreditCart;

	@FindBy(xpath = "//div[@id='payment-method-buttons-container']//input[@value='Continue']")
	private WebElement paymentMethodsCreditCartContinu;

	@FindBy(id = "CreditCardType")
	private WebElement paymentInformationCreditCartType;

	@FindBy(id = "CardholderName")
	private WebElement paymentInformationCreditCartNameUser;

	@FindBy(id = "CardNumber")
	private WebElement paymentInformationCreditCartNumber;

	@FindBy(id = "ExpireMonth")
	private WebElement paymentInformationCreditExpirationMonth;

	@FindBy(id = "ExpireYear")
	private WebElement paymentInformationCreditExpirationYear;

	@FindBy(id = "CardCode")
	private WebElement paymentInformationCreditCartCode;

	@FindBy(xpath = "//div[@id='payment-info-buttons-container']//input[@value='Continue']")
	private WebElement paymentInformationCreditContinue;

	public CheckOutProzesse(WebDriver driver) {
		super(driver);
	}

	public void billingAdresseContinue() {
		click(billingAdresseContinue, 10);
	}

	public void shippingAdresseContinue() {
		click(shippingAdresseContinue, 10);
	}

	public void shippingMethodeGround() {
		click(shippingMethodeGround, 10);
	}

	public void shippingMethodeGroundContinu() {
		click(shippingMethodeGroundContinu, 10);
	}

	public void paymentMethodsCreditCart() {
		click(paymentMethodsCreditCart, 10);
	}

	public void paymentMethodsCreditCartContinu() {
		click(paymentMethodsCreditCartContinu, 10);
	}

	public void paymentInformationCreditCartType(String visibleText) {
		select(paymentInformationCreditCartType, 10, visibleText);
	}

	public void paymentInformationCreditCartNumber(String visibleText) {
		type(paymentInformationCreditCartNumber, 10, visibleText);
	}

	public void paymentInformationCreditCartNameUser(String visibleText) {
		type(paymentInformationCreditCartNameUser, 10, visibleText);
	}

	public void paymentInformationCreditExpirationMonth(String visibleText) {
		select(paymentInformationCreditExpirationMonth, 10, visibleText);
	}

	public void paymentInformationCreditExpirationYear(String visibleText) {
		select(paymentInformationCreditExpirationYear, 10, visibleText);
	}

	public void paymentInformationCreditCartCode(String visibleText) {
		type(paymentInformationCreditCartCode, 10, visibleText);
	}

	public void paymentInformationCreditContinue() {
		click(paymentInformationCreditContinue, 10);
	}

}
