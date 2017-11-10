package test.menu;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesObjects.MenuNavegacionPage;

public class Lateral extends TestBase {

    @Test
    public void validarTextLinks() {
        MenuNavegacionPage menuNavegacon = new MenuNavegacionPage(driver, "Welcome: Mercury Tours");

        // TODO: Validar enlaces del menú lateral.
    }
}
