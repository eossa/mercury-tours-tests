package test.menu;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesObjects.MenuNavegacionPage;

public class Superior extends TestBase {

    @Test
    public void validarTextLinks() {
        MenuNavegacionPage menuNavegacon = new MenuNavegacionPage(driver, "Welcome: Mercury Tours");

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
}
