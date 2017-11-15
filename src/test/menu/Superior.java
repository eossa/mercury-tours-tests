package test.menu;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesObjects.MenuNavegacionPage;

public class Superior extends TestBase {

    @Test
    public void validarTextLinks() {
        MenuNavegacionPage menuNavegacon = new MenuNavegacionPage(driver, "Welcome: Mercury Tours");        
        
        if (!(menuNavegacon.isElementPresentAndDisplay(menuNavegacon.getLnkSingOn()))){
			Assert.fail("No se encontró el link SIGN-ON");
		}
		if (!(menuNavegacon.isElementPresentAndDisplay(menuNavegacon.getLnkRegister()))){
			Assert.fail("No se encontró el link REGISTER");
		}
		if (!(menuNavegacon.isElementPresentAndDisplay(menuNavegacon.getLnkSupport()))){
			Assert.fail("No se encontró el link SUPPORT");
		}
		if (!(menuNavegacon.isElementPresentAndDisplay(menuNavegacon.getLnkContact()))){
			Assert.fail("No se encontró el link CONTACT");
		}
    }
}
