package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class LoginPage extends PageBase {
	
	public LoginPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	// WebElements
	@FindBy(how = How.NAME, using = "userName")
	private WebElement inputUserName;
	@FindBy(how = How.NAME, using = "password")
	private WebElement inputPassword;
	@FindBy(how = How.NAME, using = "login")
	private WebElement buttonSingIn;
	@FindBy(how = How.LINK_TEXT, using = "your destination")
	private WebElement lnkDestination;
	@FindBy(how = How.LINK_TEXT, using = "featured vacation destinations")
	private WebElement lnkVacation;
	@FindBy(how = How.LINK_TEXT, using = "Register here")
	private WebElement lnkRegister;

	public WebElement getInputUserName() {
		return inputUserName;
	}

	public WebElement getInputPassword() {
		return inputPassword;
	}

	public WebElement getButtonSingIn() {
		return buttonSingIn;
	}

	public WebElement getLnkDestination() {
		return lnkDestination;
	}

	public WebElement getLnkVacation() {
		return lnkVacation;
	}

	public WebElement getLnkRegister() {
		return lnkRegister;
	}
	
	public void loginMercuryTours(String userName, String password) {
		sendText(inputUserName, userName);
		sendText(inputPassword, password);
		clickButtonLink(buttonSingIn);
	}
}
