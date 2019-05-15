package de.alain.TestCaseReorder;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Helper.MyScreenshop;
import de.alain.PageAndHTMLControl.CheckOutProzesse;
import de.alain.PageAndHTMLControl.Confirmation;
import de.alain.PageAndHTMLControl.OrderProduct;
import de.alain.PageAndHTMLControl.PostCondition;
import de.alain.PageAndHTMLControl.Precondition;
import de.alain.PageAndHTMLControl.ShoppingCartEntfernung;
import de.alain.PageAndHTMLControl.StartCheckOut;
import de.alain.PageAndHTMLControl.VerificationOfPrices;
import de.alain.PageAndHTMLControl.VerifikationIfSuccess;

public class ReorderTestFall {
	private WebDriver driver;
	public String pricejeansBlues;

	private Precondition precondition;
	private OrderProduct orderProduct;
	private StartCheckOut startCheckOut;
	private CheckOutProzesse checkOutProzesse;
	private VerificationOfPrices verificationOfPrices;
	private Confirmation confirmation;
	private VerifikationIfSuccess verifikationIfSuccess;
	private PostCondition postCondition;

	ShoppingCartEntfernung shoppingCartEntfernung;

	private Boolean testOk = false;

	@Before
	public void setUp() {
		if (driver == null) {
			System.setProperty("webdriver.firefox.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\excuteables\\geckodriver.exe");
			driver = new FirefoxDriver();
			precondition = new Precondition(driver);
			orderProduct = new OrderProduct(driver);
			startCheckOut = new StartCheckOut(driver);
			checkOutProzesse = new CheckOutProzesse(driver);
			verificationOfPrices = new VerificationOfPrices(driver);
			confirmation = new Confirmation(driver);
			verifikationIfSuccess = new VerifikationIfSuccess(driver);
			postCondition = new PostCondition(driver);
			driver.manage().window().maximize();

		}
	}

	@Test
	public void test() {
		// Precondition
		precondition.visit("http://demowebshop.tricentis.com");
		precondition.clickLogin();
		precondition.typeEmail("alain.samenwangueu@fincon.test");
		precondition.typePassword("Tosca1234!");
		precondition.submitButton();

		// Einloggen check

		assertTrue(precondition.isEmailVisible());

		// Check Ob ShoppingCart not Empty
		ShoppingCartEntfernung.wiederHerstellungVonSeite();

		// TestStep 2:
		orderProduct.productChoise();
		orderProduct.navigateToBluejeans();
		pricejeansBlues = orderProduct.priceBlueJeans();

		assertTrue(orderProduct.priceBlueJeans().equals("1.00"));
		orderProduct.typeMengeBluejeans("25");
		orderProduct.addToCartButton();
		assertTrue(orderProduct.IsBlueJeansAddToCart().equals("The product has been added to your shopping cart"));

		// TestStep 3:
		startCheckOut.shoppingCartClick();
		startCheckOut.termsOfServiceClick();
		startCheckOut.CheckOutClick();

		// TestStep 4:
		checkOutProzesse.billingAdresseContinue();
		checkOutProzesse.shippingAdresseContinue();
		checkOutProzesse.shippingMethodeGround();
		checkOutProzesse.shippingMethodeGroundContinu();
		checkOutProzesse.paymentMethodsCreditCart();
		checkOutProzesse.paymentMethodsCreditCartContinu();
		checkOutProzesse.paymentInformationCreditCartType("Visa");
		checkOutProzesse.paymentInformationCreditCartNameUser("alain Le Beau Gos");
		checkOutProzesse.paymentInformationCreditCartNumber("4485564059489345");
		checkOutProzesse.paymentInformationCreditExpirationMonth("02");
		checkOutProzesse.paymentInformationCreditExpirationYear("2021");
		checkOutProzesse.paymentInformationCreditCartCode("412");
		checkOutProzesse.paymentInformationCreditContinue();

		// TestStep 5: Verifikation

		assertTrue(verificationOfPrices.getSubTotalPreis().equals("20.00"));
		assertTrue(verificationOfPrices.getShippingGroundPreis().equals("10.00"));
		assertTrue(verificationOfPrices.getTotalPreis().equals("35.00"));

		// TestStep 6: Confirmation
		confirmation.confirmationButtonClick();

		// TestStep 7: Successfull verikation
		assertTrue(verifikationIfSuccess.verifikationOfSuccess().equals("Your order has been successfully processed!"));

		// TestStep 8: click confirm and logout
		postCondition.confirmationKaufbuttonClick();
		postCondition.logOutButtonClick();

		testOk = true;

	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		if (testOk == false) {
			MyScreenshop.makeScreenshot(driver);
		}
		driver.close();
	}

}
