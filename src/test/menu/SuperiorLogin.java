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
        
        if (!(menuNavegacon.isElementEquals(menuNavegacon.getLnkSingOff(), "SIGN-OFF"))) {
            Assert.fail("El link no contiene el texto esperado SIGN-OFF");
        }
        if (!(menuNavegacon.isElementEquals(menuNavegacon.getLnkItinerary(), "ITINERARY"))) {
            Assert.fail("El link no contiene el texto esperado ITINERARY");
        }
        if (!(menuNavegacon.isElementEquals(menuNavegacon.getLnkProfile(), "PROFILE"))) {
            Assert.fail("El link no contiene el texto esperado PROFILE");
        }
        if (!(menuNavegacon.isElementEquals(menuNavegacon.getLnkSupport(), "SUPPORT"))) {
            Assert.fail("El link no contiene el texto esperado SUPPORT");
        }
        if (!(menuNavegacon.isElementEquals(menuNavegacon.getLnkContact(), "CONTACT"))) {
            Assert.fail("El link no contiene el texto esperado CONTACT");
        }
    }
}
