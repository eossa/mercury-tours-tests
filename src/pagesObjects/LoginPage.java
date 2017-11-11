package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class LoginPage extends PageBase {
	private static ExcelUtils excelUtils;
	
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
	
	public void loginMercuryTours() {
        try {
            excelUtils = new ExcelUtils("CredencialesLogin.xlsx", ExcelType.XLSX);
            String username = excelUtils.getCellData(1, 0);
            String password = excelUtils.getCellData(1, 1);
			sendText(inputUserName, username);
			sendText(inputPassword, password);
			clickButtonLink(buttonSingIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
