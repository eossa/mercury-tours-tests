package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class SelectFlightPage extends PageBase {

	public SelectFlightPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	@FindBy(how = How.NAME, using = "reserveFlights")
	private WebElement buttonSelectFlight;
	
	public WebElement getButtonSelectFlight() {
		return buttonSelectFlight;
	}
	
	public void seleccionar() {
		radio("outFlight", "Blue Skies Airlines$361$271$7:10");
		radio("inFlight", "Unified Airlines$633$303$18:44");
		clickButtonLink(buttonSelectFlight);
	}
}
