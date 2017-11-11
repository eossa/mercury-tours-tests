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
        login.loginMercuryTours();
        // TODO: Revisar que no esté logueado.
    }
}
