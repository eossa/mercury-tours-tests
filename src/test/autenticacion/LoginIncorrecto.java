package test.autenticacion;

import base.TestBase;
import org.testng.annotations.Test;
import pagesObjects.LoginPage;
import utils.ExcelUtils;

import static org.testng.Assert.assertTrue;

public class LoginIncorrecto extends TestBase {
    @Test
    public void f() {
        LoginPage login = new LoginPage(driver, "Welcome: Mercury Tours");
        try {
            excelUtils = new ExcelUtils("CredencialesLogin.xlsx", ExcelUtils.ExcelType.XLSX);
            String username = excelUtils.getCellData(2, 0);
            String password = excelUtils.getCellData(2, 1);
            login.type("userName", username)
                    .type("password", password)
                    .click("[name='login']");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(driver.getTitle().contains("Sign-on: Mercury Tours"));
    }
}
