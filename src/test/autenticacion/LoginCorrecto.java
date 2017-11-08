package test.autenticacion;

import org.testng.annotations.Test;

import base.TestBase;
import pagesObjects.LoginPage;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class LoginCorrecto extends TestBase {
	private String pageTitleIndex = "Welcome: Mercury Tours";
	protected LoginPage login;
	String username;
	String password;

	@Test
	public void f() {
		try {
			excelUtils = new ExcelUtils("CredencialesLogin.xlsx", ExcelType.XLSX);
			username = excelUtils.getCellData(1, 0);
			password = excelUtils.getCellData(1, 1);
			login.loginMercuryTours(username, password);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
