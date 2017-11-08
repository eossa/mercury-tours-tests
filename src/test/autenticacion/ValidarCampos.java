package test.autenticacion;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pagesObjects.LoginPage;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class ValidarCampos extends TestBase {
	private String pageTitleIndex = "Welcome: Mercury Tours";
	protected LoginPage login;

	private String nomCampoUser = "";
	private String nomCampoPass = "";
	private String nomBotonSing = "";

	@Test
	public void f() {
		login = new LoginPage(driver, pageTitleIndex);
		try {
			excelUtils = new ExcelUtils("CamposLogin.xlsx", ExcelType.XLSX);

			nomCampoUser = excelUtils.getCellData(1, 0);
			nomCampoPass = excelUtils.getCellData(1, 1);
			nomBotonSing = excelUtils.getCellData(1, 2);

			if (!(login.isElementPresentAndDisplay(login.getInputUserName())))
				Assert.fail("No se encontró el campo de " + nomCampoUser);

			if (!(login.isElementPresentAndDisplay(login.getInputPassword())))
				Assert.fail("No se encontró el campo de " + nomCampoPass);

			if (!(login.isElementPresentAndDisplay(login.getButtonSingIn())))
				Assert.fail("No se encontró el botón " + nomBotonSing);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
