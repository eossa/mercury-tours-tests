package scriptsSimples;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import base.TestBase;

public class ManageMercuryTours extends TestBase {
	private StringBuffer verificationErrors = new StringBuffer();
	private static LoginMercuryTours login = null;

	@Test
	public void testLogin() throws Exception {
		if (login == null)
			login = new LoginMercuryTours();
		login.testLogin();
	}

	@Test(dependsOnMethods = { "testLogin" })
	public void testReserveCruise() throws Exception {
		try {
			assertTrue(isElementPresent(By.linkText("Cruises")));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("Cruises")).click();
		driver.findElement(By.cssSelector("img[alt=\"Reservations Open\"]")).click();
	}

	@Test(dependsOnMethods = { "testReserveCruise" })
	public void testDoReserve() throws Exception {
		driver.findElement(By.name("findFlights")).click();
		driver.findElement(By.name("reserveFlights")).click();
		driver.findElement(By.name("passFirst0")).clear();
		driver.findElement(By.name("passFirst0")).sendKeys("John");
		driver.findElement(By.name("passLast0")).clear();
		driver.findElement(By.name("passLast0")).sendKeys("Doe");
		driver.findElement(By.name("creditnumber")).clear();
		driver.findElement(By.name("creditnumber")).sendKeys("283937517383");
		driver.findElement(By.name("buyFlights")).click();
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
