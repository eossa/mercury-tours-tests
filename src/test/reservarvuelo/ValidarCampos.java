package test.reservarvuelo;

import base.TestBase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObjects.BookFlightPage;
import pagesObjects.FindFlightPage;
import pagesObjects.LoginPage;
import pagesObjects.SelectFlightPage;
import utils.ExcelUtils;

public class ValidarCampos extends TestBase {
    @Test
    public void findFlight() {
        LoginPage loginPage = new LoginPage(driver, "Welcome: Mercury Tours");
        loginPage.loginMercuryTours();

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

    @Test(dependsOnMethods = {"findFlight"})
    public void selectFlight() {
    		FindFlightPage findFlight = new FindFlightPage(driver, "Find a Flight: Mercury Tours");
    		findFlight.clickButtonLink(findFlight.getButtonFindFlights());
        String pageTitle = "Select a Flight: Mercury Tours";
        SelectFlightPage selectFlightPage = new SelectFlightPage(driver, pageTitle);
        if (!selectFlightPage.isPageLoad())
            Assert.fail("No se encuentra en la página " + pageTitle);
    }
    
    @Test(dependsOnMethods = {"selectFlight"})
    public void bookFlight() {
    		SelectFlightPage selectFlightPage = new SelectFlightPage(driver, "Select a Flight: Mercury Tours");
		selectFlightPage.clickButtonLink(selectFlightPage.getButtonSelectFlight());
        BookFlightPage bookFlightPage = new BookFlightPage(driver, "Book a Flight: Mercury Tours");
        
    		try {
    			ExcelUtils excelUtils = new ExcelUtils("CamposBookFlight.xlsx", ExcelUtils.ExcelType.XLSX);
		
	    		String firstName = excelUtils.getCellData(0, 0);
	        String lastName = excelUtils.getCellData(0, 1);
	        String meal = excelUtils.getCellData(0, 2);
	        String creditCard = excelUtils.getCellData(0, 3);
	        String creditNumber = excelUtils.getCellData(0,  4);
	        String expMN = excelUtils.getCellData(0, 5);
	        String expYR = excelUtils.getCellData(0, 6);
	        String ccFirstName = excelUtils.getCellData(0, 7);
	        String ccMid = excelUtils.getCellData(0, 8);
	        String ccLastName = excelUtils.getCellData(0, 9);
        
	        if (!(bookFlightPage.isElementPresentAndDisplay(bookFlightPage.resolveForTyping(firstName))))
                Assert.fail("No se encontró el campo de " + firstName);

            if (!(bookFlightPage.isElementPresentAndDisplay(bookFlightPage.resolveForTyping(lastName))))
                Assert.fail("No se encontró el campo de " + lastName);

            if (!(bookFlightPage.isElementPresentAndDisplay(bookFlightPage.resolveForSelection(meal))))
                Assert.fail("No se encontró el campo de " + meal);

            if (!(bookFlightPage.isElementPresentAndDisplay(bookFlightPage.resolveForSelection(creditCard))))
                Assert.fail("No se encontró el campo de " + creditCard);

            if (!(bookFlightPage.isElementPresentAndDisplay(bookFlightPage.resolveForTyping(creditNumber))))
                Assert.fail("No se encontró el campo de " + creditNumber);
            
            if (!(bookFlightPage.isElementPresentAndDisplay(bookFlightPage.resolveForSelection(expMN))))
                Assert.fail("No se encontró el campo de " + expMN);

            if (!(bookFlightPage.isElementPresentAndDisplay(bookFlightPage.resolveForSelection(expYR))))
                Assert.fail("No se encontró el campo de " + expYR);

            if (!(bookFlightPage.isElementPresentAndDisplay(bookFlightPage.resolveForTyping(ccFirstName))))
                Assert.fail("No se encontró el campo de " + ccFirstName);

            if (!(bookFlightPage.isElementPresentAndDisplay(bookFlightPage.resolveForTyping(ccMid))))
                Assert.fail("No se encontró el campo de " + ccMid);

            if (!(bookFlightPage.isElementPresentAndDisplay(bookFlightPage.resolveForTyping(ccLastName))))
                Assert.fail("No se encontró el campo de " + ccLastName);
	        
    		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
