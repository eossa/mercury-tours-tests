package test.registro;

import base.TestBase;
import org.testng.annotations.Test;
import pagesObjects.RegisterPage;

public class Registrar extends TestBase {
    @Test
    public void f() {
        RegisterPage registerPage = new RegisterPage(driver, "Register: Mercury Tours");
        registerPage.registrar();
    }
}
