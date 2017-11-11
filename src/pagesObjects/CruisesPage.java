package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class CruisesPage extends PageBase {

	@FindBy(how = How.CSS, using = "img[alt='Reservations Open']")
	private WebElement imgReservation;
	
	public CruisesPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	public WebElement getImgReservation() {
		return imgReservation;
	}
	
	public void reservarAhora() {
		clickButtonLink(imgReservation);
	}

}
