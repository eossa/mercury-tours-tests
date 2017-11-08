package scriptsSimples;

import org.testng.annotations.*;

import base.TestBase;

import org.openqa.selenium.*;

public class ReservarVuelo extends TestBase {
	@Test
	public void testReservar() throws Exception {
		(new LoginMercuryTours()).testLogin();
		driver.findElement(By.name("findFlights")).click();
		driver.findElement(By.name("reserveFlights")).click();
		driver.findElement(By.name("passFirst0")).clear();
		driver.findElement(By.name("passFirst0")).sendKeys("Elkin");
		driver.findElement(By.name("passLast0")).clear();
		driver.findElement(By.name("passLast0")).sendKeys("Ossa");
		driver.findElement(By.name("creditnumber")).clear();
		driver.findElement(By.name("creditnumber")).sendKeys("3132647912");
		driver.findElement(By.name("buyFlights")).click();
		driver.findElement(By.xpath("//td[3]/a/img")).click();
	}
}
