package test.reservarvuelo;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesObjects.FindFlightPage;

public class ValidarCampos extends TestBase {
    @Test
    public void findFlight() {
        FindFlightPage findFlight = new FindFlightPage(driver, "Find a Flight: Mercury Tours");

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
}
