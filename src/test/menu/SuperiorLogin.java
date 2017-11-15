package test.menu;

import base.TestBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObjects.LoginPage;
import pagesObjects.MenuNavegacionPage;

public class SuperiorLogin extends TestBase {

    @Test
    public void validarTextLinks() {
        MenuNavegacionPage menuNavegacon = new MenuNavegacionPage(driver, "Welcome: Mercury Tours");
        
        LoginPage login = new LoginPage(driver, "Welcome: Mercury Tours");
        login.loginMercuryTours();
        
        if (!(menuNavegacon.isElementPresentAndDisplay(menuNavegacon.getLnkSingOff()))){
			Assert.fail("No se encontró el link SIGN-OFF");
		}
		if (!(menuNavegacon.isElementPresentAndDisplay(menuNavegacon.getLnkItinerary()))){
			Assert.fail("No se encontró el link ITINERARY");
		}
		if (!(menuNavegacon.isElementPresentAndDisplay(menuNavegacon.getLnkProfile()))){
			Assert.fail("No se encontró el link PROFILE");
		}
		if (!(menuNavegacon.isElementPresentAndDisplay(menuNavegacon.getLnkSupport()))){
			Assert.fail("No se encontró el link SUPPORT");
		}
		if (!(menuNavegacon.isElementPresentAndDisplay(menuNavegacon.getLnkContact()))){
			Assert.fail("No se encontró el link CONTACT");
		}
    }
}
