package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class MenuNavegacionPage extends PageBase {
	
	public MenuNavegacionPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	// WebElements menú superior
	@FindBy(how = How.LINK_TEXT, using = "SIGN-ON")
	private WebElement lnkSingOn;
	@FindBy(how = How.LINK_TEXT, using = "REGISTER")
	private WebElement lnkRegister;
	@FindBy(how = How.LINK_TEXT, using = "SUPPORT")
	private WebElement lnkSupport;
	@FindBy(how = How.LINK_TEXT, using = "CONTACT")
	private WebElement lnkContact;
	
	// WebElements menú superior login
	@FindBy(how = How.LINK_TEXT, using = "SIGN-OFF")
	private WebElement lnkSingOff;
	@FindBy(how = How.LINK_TEXT, using = "ITINERARY")
	private WebElement lnkItinerary;
	@FindBy(how = How.LINK_TEXT, using = "PROFILE")
	private WebElement lnkProfile;

	// WebElements menú lateral
	@FindBy(how = How.LINK_TEXT, using = "Home")
	private WebElement lnkHome;
	@FindBy(how = How.LINK_TEXT, using = "Flights")
	private WebElement lnkFlights;
	@FindBy(how = How.LINK_TEXT, using = "Hotels")
	private WebElement lnkHotels;
	@FindBy(how = How.LINK_TEXT, using = "Car Rentals")
	private WebElement lnkCarRentals;
	@FindBy(how = How.LINK_TEXT, using = "Cruises")
	private WebElement lnkCruises;
	@FindBy(how = How.LINK_TEXT, using = "Destinations")
	private WebElement lnkDestinations;
	@FindBy(how = How.LINK_TEXT, using = "Vacations")
	private WebElement lnkVacations;

	public WebElement getLnkSingOn() {
		return lnkSingOn;
	}

	public WebElement getLnkRegister() {
		return lnkRegister;
	}

	public WebElement getLnkSupport() {
		return lnkSupport;
	}

	public WebElement getLnkContact() {
		return lnkContact;
	}

	public WebElement getLnkHome() {
		return lnkHome;
	}

	public WebElement getLnkFlights() {
		return lnkFlights;
	}

	public WebElement getLnkHotels() {
		return lnkHotels;
	}

	public WebElement getLnkCarRentals() {
		return lnkCarRentals;
	}

	public WebElement getLnkCruises() {
		return lnkCruises;
	}

	public WebElement getLnkDestinations() {
		return lnkDestinations;
	}

	public WebElement getLnkVacations() {
		return lnkVacations;
	}
	
	public void clickLink(WebElement element) {
		clickButtonLink(element);
	}

	public WebElement getLnkItinerary() {
		return lnkItinerary;
	}

	public WebElement getLnkProfile() {
		return lnkProfile;
	}

	public WebElement getLnkSingOff() {
		return lnkSingOff;
	}
}
