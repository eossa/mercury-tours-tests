package test.reservarvuelo;

import base.TestBase;
import org.testng.annotations.Test;
import pagesObjects.BookFlightPage;
import pagesObjects.CruisesPage;
import pagesObjects.FindFlightPage;
import pagesObjects.LoginPage;
import pagesObjects.MenuNavegacionPage;
import pagesObjects.SelectFlightPage;

public class ReservarByCruises extends TestBase {

	@Test()
	public void f() {
		CruisesPage cruisesPage = new CruisesPage(driver, "Cruises: Mercury Tours");
        LoginPage loginPage = new LoginPage(driver, "Welcome: Mercury Tours");
        MenuNavegacionPage menuNavegacionPage = new MenuNavegacionPage(driver, "Welcome: Mercury Tours");
        loginPage.loginMercuryTours();
        menuNavegacionPage.clickButtonLink(menuNavegacionPage.getLnkCruises());
        cruisesPage.reservarAhora();
	}
	
    @Test(dependsOnMethods = {"f"})
    public void buscarVuelos() {
    		FindFlightPage findFlight = new FindFlightPage(driver, "Find a Flight: Mercury Tours");
        findFlight.buscar();
    }

    @Test(dependsOnMethods = {"buscarVuelos"})
    public void seleccionarVuelo() {
        SelectFlightPage selectFlight = new SelectFlightPage(driver, "Select a Flight: Mercury Tours");
        selectFlight.seleccionar();
    }

    @Test(dependsOnMethods = {"seleccionarVuelo"})
    public void reservarVuelo() {
        BookFlightPage bookFlight = new BookFlightPage(driver, "Book a Flight: Mercury Tours");
        bookFlight.reservar();
    }
}
