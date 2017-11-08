package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pagesObjects.BookFlightPage;
import pagesObjects.FindFlightPage;
import pagesObjects.LoginPage;
import pagesObjects.MenuNavegacionPage;
import pagesObjects.SelectFlightPage;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class NavegacionMenu extends TestBase {
	protected MenuNavegacionPage menuNavegacon;
	protected LoginPage login;
	protected FindFlightPage findFlight;
	protected SelectFlightPage selectFlight;
	protected BookFlightPage bookFlight;
	private String pageTitleIndex = "Welcome: Mercury Tours";
	private String pageFindFlight = "Find a Flight: Mercury Tours";
	private String pageSelectFlight = "Select a Flight: Mercury Tours";
	private String pageBookFlight = "Book a Flight: Mercury Tours";

	@Test
	public void validarTextLinks() {
		menuNavegacon = new MenuNavegacionPage(driver, pageTitleIndex);

		if (!(menuNavegacon.isElementEquals(menuNavegacon.getLnkSingOn(), "SIGN-ON"))) {
			Assert.fail("El link no contiene el texto esperado SIGN-ON");
		}
		if (!(menuNavegacon.isElementEquals(menuNavegacon.getLnkRegister(), "REGISTER"))) {
			Assert.fail("El link no contiene el texto esperado REGISTER");
		}
		if (!(menuNavegacon.isElementEquals(menuNavegacon.getLnkSupport(), "SUPPORT"))) {
			Assert.fail("El link no contiene el texto esperado SUPPORT");
		}
		if (!(menuNavegacon.isElementEquals(menuNavegacon.getLnkContact(), "CONTACT"))) {
			Assert.fail("El link no contiene el texto esperado CONTACT");
		}
	}

	@Test(priority = 3)
	public void verificarCamposBuscarVuelos() {
		findFlight = new FindFlightPage(driver, pageFindFlight);

		if (!(findFlight.isElementPresentAndDisplay(findFlight.getRadioRoundTrip())))
			Assert.fail("No se encontró el radio round trip");

		if (!(findFlight.isElementPresentAndDisplay(findFlight.getRadioOneWay())))
			Assert.fail("No se encontró el radio one way");

		if (!(findFlight.isElementPresentAndDisplay(findFlight.getSelectPassCount())))
			Assert.fail("No se encontró el select passengers");

		if (!(findFlight.isElementPresentAndDisplay(findFlight.getSelectFromPort())))
			Assert.fail("No se encontró el select departing from");

		if (!(findFlight.isElementPresentAndDisplay(findFlight.getSelectFromMonth())))
			Assert.fail("No se encontró el select on month");

		if (!(findFlight.isElementPresentAndDisplay(findFlight.getSelectFromDay())))
			Assert.fail("No se encontró el select on day");

		if (!(findFlight.isElementPresentAndDisplay(findFlight.getSelectToPort())))
			Assert.fail("No se encontró el select arriving in");

		if (!(findFlight.isElementPresentAndDisplay(findFlight.getSelectToMonth())))
			Assert.fail("No se encontró el select returning month");

		if (!(findFlight.isElementPresentAndDisplay(findFlight.getSelectToDay())))
			Assert.fail("No se encontró el select returning day");

		if (!(findFlight.isElementPresentAndDisplay(findFlight.getRbtnCoach())))
			Assert.fail("No se encontró el radio service class coach");

		if (!(findFlight.isElementPresentAndDisplay(findFlight.getRbtnBusiness())))
			Assert.fail("No se encontró el radio service class business");

		if (!(findFlight.isElementPresentAndDisplay(findFlight.getRbtnFirst())))
			Assert.fail("No se encontró el radio service class first");

		if (!(findFlight.isElementPresentAndDisplay(findFlight.getSelectAirline())))
			Assert.fail("No se encontró el select airline");
	}

	@Test(priority = 4)
	public void buscarVuelos() {
		findFlight.buscar();
	}

	@Test(priority = 5)
	public void seleccionarVuelo() {
		selectFlight = new SelectFlightPage(driver, pageSelectFlight);
		selectFlight.seleccionar();
	}

	@Test(priority = 6)
	public void reservarVuelo() {
		bookFlight = new BookFlightPage(driver, pageBookFlight);
		bookFlight.reservar();
		;
	}
}
