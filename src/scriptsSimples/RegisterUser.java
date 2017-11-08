package scriptsSimples;

import base.TestBase;
import org.testng.annotations.*;
import org.openqa.selenium.*;

public class RegisterUser extends TestBase {
  @Test
  public void testRegisterUser() throws Exception {
    driver.get(WEB_SERVER + "/mercurysignon.php");
    driver.findElement(By.linkText("REGISTER")).click();
    driver.findElement(By.name("firstName")).clear();
    driver.findElement(By.name("firstName")).sendKeys("John");
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys("Doe");
    driver.findElement(By.name("phone")).clear();
    driver.findElement(By.name("phone")).sendKeys("7212121");
    driver.findElement(By.id("userName")).clear();
    driver.findElement(By.id("userName")).sendKeys("john@example.com");
    driver.findElement(By.name("address1")).clear();
    driver.findElement(By.name("address1")).sendKeys("Av. Green Lake");
    driver.findElement(By.name("city")).clear();
    driver.findElement(By.name("city")).sendKeys("Lousiana");
    driver.findElement(By.name("state")).clear();
    driver.findElement(By.name("state")).sendKeys("Detroid");
    driver.findElement(By.name("postalCode")).clear();
    driver.findElement(By.name("postalCode")).sendKeys("84123");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("johndoe");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("secret");
    driver.findElement(By.name("confirmPassword")).clear();
    driver.findElement(By.name("confirmPassword")).sendKeys("secret");
    driver.findElement(By.name("register")).click();
  }
}
