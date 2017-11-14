package pagesObjects;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignOnPage extends PageBase {

    public SignOnPage(WebDriver driver, String pageTitle) {
        super(driver, pageTitle);
    }

    public void singOn(String username, String password) {
        visit("mercurysignon.php")
                .type("userName", username)
                .type("password", password)
                .click("[name='login']");
    }
}
