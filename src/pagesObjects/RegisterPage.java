package pagesObjects;

import org.openqa.selenium.WebDriver;

import base.PageBase;
import utils.ExcelUtils;

public class RegisterPage extends PageBase {

    public RegisterPage(WebDriver driver, String pageTitle) {
        super(driver, pageTitle);
    }

    public void registrar() {
        try {
            ExcelUtils excelUtils = new ExcelUtils("CredencialesRegistro.xlsx", ExcelUtils.ExcelType.XLSX);
            String firstName = excelUtils.getCellData(1, 0);
            String lastName = excelUtils.getCellData(1, 1);
            String phone = excelUtils.getCellData(1, 2);
            String userName = excelUtils.getCellData(1, 3);
            String address1 = excelUtils.getCellData(1, 4);
            String address2 = excelUtils.getCellData(1, 5);
            String city = excelUtils.getCellData(1, 6);
            String state = excelUtils.getCellData(1, 7);
            String postalCode = excelUtils.getCellData(1, 8);
            // String country = excelUtils.getCellData(1, 9); // Throws exception when is a number.
            String country = "42";
            String email = excelUtils.getCellData(1, 10);
            String password = excelUtils.getCellData(1, 11);
            String passwordConfirm = excelUtils.getCellData(1, 12);

            visit("/mercuryregister.php")
                    .type("firstName", firstName)
                    .type("lastName", lastName)
                    .type("phone", phone)
                    .type("userName", userName)
                    .type("address1", address1)
                    .type("address2", address2)
                    .type("city", city)
                    .type("state", state)
                    .type("postalCode", postalCode)
                    .select("country", country)
                    .type("email", email)
                    .type("password", password)
                    .type("confirmPassword", passwordConfirm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
