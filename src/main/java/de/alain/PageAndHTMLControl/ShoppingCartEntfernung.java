package de.alain.PageAndHTMLControl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartEntfernung extends Base {

	// Diese Funktion überprüft, ob schon Menge Produckt größer 0 ist. Fall ja, dann
	// wird alle Produkt Remove
	private static Boolean hilfsvariabel = false;

	public ShoppingCartEntfernung(WebDriver driver) {
		super(driver);
	}

	public static void wiederHerstellungVonSeite() {

		while (hilfsvariabel == false) {
			String listlang = driver.findElement(By.xpath("//li[@id='topcartlink']//a[@class='ico-cart']")).getText();
			if (listlang.contains("(0)")) {
				hilfsvariabel = true;
			}
			if (hilfsvariabel == false) {
				WebElement shoppingCart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
				shoppingCart.click();
				if (driver.findElement(By.xpath("//th[contains(text(),'Remove')]")).isDisplayed()) {
					driver.findElement(By.xpath("//table[@class='cart']//tbody//tr[1]//td[1]"));
					driver.findElement(By.xpath("//input[@type='checkbox']")).click();
					driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();
				}
			}
		}
	}

}
