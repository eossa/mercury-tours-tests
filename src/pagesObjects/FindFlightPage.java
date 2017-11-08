package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class FindFlightPage extends PageBase {
	
	public FindFlightPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	// WebElements Flight Details
	@FindBy(how = How.CSS, using = "[name='tripType'][value='roundtrip']")
	private WebElement rbtnRoundTrip;
	@FindBy(how = How.CSS, using = "[name='tripType'][value='oneway']")
	private WebElement rbtnOneWay;
	@FindBy(how = How.NAME, using = "passCount")
	private WebElement selectPassCount;
	@FindBy(how = How.NAME, using = "fromPort")
	private WebElement selectFromPort;
	@FindBy(how = How.NAME, using = "fromMonth")
	private WebElement selectFromMonth;
	@FindBy(how = How.NAME, using = "fromDay")
	private WebElement selectFromDay;
	@FindBy(how = How.NAME, using = "toPort")
	private WebElement selectToPort;
	@FindBy(how = How.NAME, using = "toMonth")
	private WebElement selectToMonth;
	@FindBy(how = How.NAME, using = "toDay")
	private WebElement selectToDay;

	// WebElements Preferences
	@FindBy(how = How.CSS, using = "[name='servClass'][value='Coach']")
	private WebElement rbtnCoach;
	@FindBy(how = How.CSS, using = "[name='servClass'][value='Business']")
	private WebElement rbtnBusiness;
	@FindBy(how = How.CSS, using = "[name='servClass'][value='First']")
	private WebElement rbtnFirst;
	@FindBy(how = How.NAME, using = "airline")
	private WebElement selectAirline;
	
	@FindBy(how = How.NAME, using = "findFlights")
	private WebElement buttonFindFlights;

	public WebElement getRadioRoundTrip() {
		return rbtnRoundTrip;
	}

	public WebElement getRadioOneWay() {
		return rbtnOneWay;
	}

	public WebElement getSelectPassCount() {
		return selectPassCount;
	}

	public WebElement getSelectFromPort() {
		return selectFromPort;
	}

	public WebElement getSelectFromMonth() {
		return selectFromMonth;
	}

	public WebElement getSelectFromDay() {
		return selectFromDay;
	}

	public WebElement getSelectToPort() {
		return selectToPort;
	}

	public WebElement getSelectToMonth() {
		return selectToMonth;
	}

	public WebElement getSelectToDay() {
		return selectToDay;
	}

	public WebElement getRbtnCoach() {
		return rbtnCoach;
	}

	public WebElement getRbtnBusiness() {
		return rbtnBusiness;
	}

	public WebElement getRbtnFirst() {
		return rbtnFirst;
	}

	public WebElement getSelectAirline() {
		return selectAirline;
	}

	public WebElement getButtonFindFlights() {
		return buttonFindFlights;
	}
	
	public void buscar() {
		clickButtonLink(rbtnOneWay);
		selectDropdownValue(selectPassCount, "3");
		
		selectDropdownValue(selectFromPort, "London");
		selectDropdownValue(selectFromMonth, "12");
		selectDropdownValue(selectFromDay, "21");

		selectDropdownValue(selectToPort, "New York");
		selectDropdownValue(selectToMonth, "12");
		selectDropdownValue(selectToDay, "30");

		clickButtonLink(rbtnBusiness);
		selectDropdownVisibleText(selectAirline, "Unified Airlines");
		clickButtonLink(buttonFindFlights);
	}
}
