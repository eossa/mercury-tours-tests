package pagesObjects;

import org.openqa.selenium.WebDriver;

import base.PageBase;

public class BookFlightPage extends PageBase {

	public BookFlightPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	public void reservar() {
		type("passFirst0", "John")
			.type("passLast0", "Doe")
			.select("pass.0.meal", "LSML")
			.select("creditCard", "IK")
			.type("creditnumber", "1234567890")
			.selectByText("cc_exp_dt_mn", "09")
			.type("cc_frst_name", "John")
			.type("cc_mid_name", "W.")
			.type("cc_last_name", "Doe")
			.type("billAddress1", "Av. avenue # 12")
			.type("billCity", "New York")
			.type("billState", "WA")
			.type("delAddress1", "St. 12 # 33 - 2")
			.type("delCity", "Miami")
			.type("delState", "FL")
			.click("input[name='buyFlights']");
	}
}
