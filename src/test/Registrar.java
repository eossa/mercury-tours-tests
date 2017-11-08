package test;

import org.testng.annotations.Test;

import base.TestBase;
import pagesObjects.RegisterPage;

public class Registrar extends TestBase {
	protected RegisterPage registerPage;
	private String pageTitleIndex = "Register: Mercury Tours";
	
	@Test
	public void f() {
		registerPage = new RegisterPage(driver, pageTitleIndex);
		registerPage.registrar();
	}
}
