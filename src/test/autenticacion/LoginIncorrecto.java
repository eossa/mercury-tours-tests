package test.autenticacion;

import base.TestBase;
import org.testng.annotations.Test;
import pagesObjects.LoginPage;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class LoginIncorrecto extends TestBase {
    @Test
    public void f() {
        LoginPage login = new LoginPage(driver, "Welcome: Mercury Tours");
        try {
            excelUtils = new ExcelUtils("CredencialesLogin.xlsx", ExcelType.XLSX);
            String username = excelUtils.getCellData(2, 0);
            String password = excelUtils.getCellData(2, 1);
            login.loginMercuryTours(username, password);
            // TODO verify that is not logged
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
