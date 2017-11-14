package test.menu;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesObjects.MenuNavegacionPage;

public class Lateral extends TestBase {

    @Test
    public void validarTextLinks() {
        MenuNavegacionPage menuNavegacon = new MenuNavegacionPage(driver, "Welcome: Mercury Tours");

        if (!(menuNavegacon.isElementPresentAndDisplay(menuNavegacon.getLnkHome()))){
			Assert.fail("No se encontró el link Home");
		}
		if (!(menuNavegacon.isElementPresentAndDisplay(menuNavegacon.getLnkFlights()))){
			Assert.fail("No se encontró el link Flights");
		}
		if (!(menuNavegacon.isElementPresentAndDisplay(menuNavegacon.getLnkHotels()))){
			Assert.fail("No se encontró el link Hotels");
		}
		if (!(menuNavegacon.isElementPresentAndDisplay(menuNavegacon.getLnkCarRentals()))){
			Assert.fail("No se encontró el link Car Rentals");
		}
		if (!(menuNavegacon.isElementPresentAndDisplay(menuNavegacon.getLnkCruises()))){
			Assert.fail("No se encontró el link Cruises");
		}
		if (!(menuNavegacon.isElementPresentAndDisplay(menuNavegacon.getLnkDestinations()))){
			Assert.fail("No se encontró el link Destinations");
		}
		if (!(menuNavegacon.isElementPresentAndDisplay(menuNavegacon.getLnkVacations()))){
			Assert.fail("No se encontró el link Vacations");
		}
    }
}
