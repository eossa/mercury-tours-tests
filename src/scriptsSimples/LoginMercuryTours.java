package scriptsSimples;

import org.testng.annotations.*;

import base.TestBase;

import org.openqa.selenium.*;

public class LoginMercuryTours extends TestBase {
	@Test
	public void testLogin() throws Exception {
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
	}
}
