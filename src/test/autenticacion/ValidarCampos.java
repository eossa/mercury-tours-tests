package test.autenticacion;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesObjects.LoginPage;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class ValidarCampos extends TestBase {
    @Test
    public void f() {
        LoginPage login = new LoginPage(driver, "Welcome: Mercury Tours");
        try {
            excelUtils = new ExcelUtils("CamposLogin.xlsx", ExcelType.XLSX);

            String nomCampoUser = excelUtils.getCellData(1, 0);
            String nomCampoPass = excelUtils.getCellData(1, 1);
            String nomBotonSing = excelUtils.getCellData(1, 2);

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
