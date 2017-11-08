package pagesObjects;

import org.openqa.selenium.WebDriver;

import base.PageBase;

public class RegisterPage extends PageBase {

	public RegisterPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	public void registrar() {
		visit("/mercuryregister.php")
			.type("firstName", "John")
			.type("lastName", "Doe")
			.type("phone", "Doe")
			.type("userName", "johndoe@example.com")
			.type("address1", "Calle 3 Norte. No 18 - 36")
			.type("address2", "Bario Nueva Cecilia")
			.type("city", "Armenia")
			.type("state", "Quindío")
			.type("postalCode", "630001")
			.select("country", "42")
			.type("email", "johndoe@example.com")
			.type("password", "secret")
			.type("confirmPassword", "secret");
	}
}
