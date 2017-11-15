package test.registro;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesObjects.LoginPage;
import pagesObjects.RegisterPage;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

import java.io.IOException;

public class ValidarCampos extends TestBase {
    @Test
    public void f() {
        try {
            RegisterPage registerPage = new RegisterPage(driver, "Register: Mercury Tours");
            ExcelUtils excelUtils = new ExcelUtils("CredencialesRegistro.xlsx", ExcelUtils.ExcelType.XLSX);
            String firstName = excelUtils.getCellData(0, 0);
            String lastName = excelUtils.getCellData(0, 1);
            String phone = excelUtils.getCellData(0, 2);
            String userName = excelUtils.getCellData(0, 3);
            String address0 = excelUtils.getCellData(0, 4);
            String city = excelUtils.getCellData(0, 6);
            String state = excelUtils.getCellData(0, 7);
            String postalCode = excelUtils.getCellData(0, 8);
            String country = excelUtils.getCellData(0, 9);
            String email = excelUtils.getCellData(0, 10);
            String password = excelUtils.getCellData(0, 11);
            String passwordConfirm = excelUtils.getCellData(0, 12);

            registerPage.visit("mercuryregister.php");

            if (!(registerPage.isElementPresentAndDisplay(registerPage.resolveForTyping(firstName))))
                Assert.fail("No se encontró el campo de " + firstName);

            if (!(registerPage.isElementPresentAndDisplay(registerPage.resolveForTyping(lastName))))
                Assert.fail("No se encontró el campo de " + lastName);

            if (!(registerPage.isElementPresentAndDisplay(registerPage.resolveForTyping(phone))))
                Assert.fail("No se encontró el campo de " + phone);

            if (!(registerPage.isElementPresentAndDisplay(registerPage.resolveForTyping(userName))))
                Assert.fail("No se encontró el campo de " + userName);

            if (!(registerPage.isElementPresentAndDisplay(registerPage.resolveForTyping(address0))))
                Assert.fail("No se encontró el campo de " + address0);

            if (!(registerPage.isElementPresentAndDisplay(registerPage.resolveForTyping(city))))
                Assert.fail("No se encontró el campo de " + city);

            if (!(registerPage.isElementPresentAndDisplay(registerPage.resolveForTyping(state))))
                Assert.fail("No se encontró el campo de " + state);

            if (!(registerPage.isElementPresentAndDisplay(registerPage.resolveForTyping(postalCode))))
                Assert.fail("No se encontró el campo de " + postalCode);

            if (!(registerPage.isElementPresentAndDisplay(registerPage.resolveForSelection(country))))
                Assert.fail("No se encontró el campo de " + country);

            if (!(registerPage.isElementPresentAndDisplay(registerPage.resolveForTyping(email))))
                Assert.fail("No se encontró el campo de " + email);

            if (!(registerPage.isElementPresentAndDisplay(registerPage.resolveForTyping(password))))
                Assert.fail("No se encontró el campo de " + password);

            if (!(registerPage.isElementPresentAndDisplay(registerPage.resolveForTyping(passwordConfirm))))
                Assert.fail("No se encontró el campo de " + passwordConfirm);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
