package test.reservarvuelo;

import base.TestBase;
import org.testng.annotations.Test;
import pagesObjects.BookFlightPage;
import pagesObjects.FindFlightPage;
import pagesObjects.SelectFlightPage;

public class ReservarCorrecto extends TestBase {

    @Test
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
