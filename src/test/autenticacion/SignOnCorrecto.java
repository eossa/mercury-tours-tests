package test.autenticacion;

import base.TestBase;
import org.testng.annotations.Test;
import pagesObjects.SignOnPage;
import utils.ExcelUtils;

import static org.testng.Assert.assertTrue;

public class SignOnCorrecto extends TestBase {
    @Test
    public void f() {
        SignOnPage login = new SignOnPage(driver, "Sign-on: Mercury Tours");
        try {
            excelUtils = new ExcelUtils("CredencialesLogin.xlsx", ExcelUtils.ExcelType.XLSX);
            String username = excelUtils.getCellData(1, 0);
            String password = excelUtils.getCellData(1, 1);
            login.singOn(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(driver.getTitle().contains("Find a Flight: Mercury Tours"));
    }
}
