package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	/**
	 * Crear el driver
	 */
	protected WebDriver driver;
	/**
	 * Título de página esperado. Será usuado en isPageLoad () para comprobar si la
	 * página está cargada.
	 */
	protected String pageTitle;

	public PageBase(WebDriver driver, String pageTitle) {
		this.driver = driver;
		this.pageTitle = pageTitle;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Comprueba si la página se carga comparando el título de página esperado con
	 * un título de página real.
	 **/
	public boolean isPageLoad() {
		return (driver.getTitle().contains(pageTitle));
	}

	/**
	 * Retorna el título de la página
	 */
	public String getTitle() {
		return pageTitle;
	}

	/**
	 * Envía el texto recibido al elemento que recibe por parámetro
	 * 
	 * @param element
	 * @param text
	 * @return
	 */
	public boolean sendText(WebElement element, String text) {
		boolean result = true;
		if (isElementPresentAndDisplay(element)) {
			element.clear();
			element.sendKeys(text);
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * Hace clic sobre el elemento que recibe por parámetro
	 * 
	 * @param element
	 * @return
	 */
	public boolean clickButtonLink(WebElement element) {
		boolean result = true;
		if (isElementPresentAndDisplay(element)) {
			element.click();
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * Verifica si el texto esta presente en la página
	 */
	public boolean isTextPresent(String text) {
		return driver.getPageSource().contains(text);
	}

	/**
	 * Verifica si el elemento esta presente en la página
	 */
	public boolean isElementPresentAndDisplay(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isElementPresentAndDisplay(String selector) {
		try {
			return driver.findElement(By.cssSelector(selector)).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean selectDropdownVisibleText(WebElement element, String text) {
		boolean result = true;
		if (isElementPresentAndDisplay(element)) {
			new Select(element).selectByVisibleText(text);
		} else
			result = false;
		return result;
	}

	public boolean selectDropdownValue(WebElement element, String value) {
		boolean result = true;
		if (isElementPresentAndDisplay(element)) {
			new Select(element).selectByValue(value);
		} else
			result = false;
		return result;
	}
	
	public boolean selectDropdownAjax(WebElement select, WebElement selectOptions, String text) {
		boolean result = true;
		if (isElementPresentAndDisplay(select)) {
			List<WebElement> options = selectOptions.findElements(By.tagName("li"));
			for (WebElement option : options) {
				if (option.getText().equals(text)) {
					option.click(); // Click the desired option
					break;
				}
			}
		} else
			result = false;
		return result;
	}

	public boolean isElementEquals(WebElement element, String value) {
		boolean result = true;
		if (isElementPresentAndDisplay(element)) {
			result = element.getText().equalsIgnoreCase(value);
		} else
			result = false;
		return result;
	}

	public boolean elementPresent(By element) {
		return isElementPresentAndDisplay(driver.findElement(element));
	}
	
	public WebElement resolveForRadioSelection(String fieldName, String value) {
		return driver.findElement(By.cssSelector("input[type=radio][name='"+fieldName+"'][value='"+value+"']"));
	}
	
	public WebElement resolveForSelection(String fieldName) {
		return driver.findElement(By.cssSelector("select[name='"+fieldName+"']"));
	}
	
	public WebElement resolveForTyping(String fieldName) {
		return driver.findElement(By.cssSelector("input[name='"+fieldName+"']"));
	}
	
	public void radio(String fieldName, String value) {
		clickButtonLink(resolveForRadioSelection(fieldName, value));
	}
	
	public PageBase type(String fieldName, String value) {
		sendText(resolveForTyping(fieldName), value);
		return this;
	}
	
	public PageBase click(String selector) {
		driver.findElement((By.cssSelector(selector))).click();
		return this;
	}
	
	public PageBase select(String fieldName, String value) {
		WebElement element = resolveForSelection(fieldName);
		
		List<WebElement> options = element.findElements(By.tagName("option"));
		
		for (WebElement option : options) {
			if (option.getAttribute("value").equals(value) || option.getText().contains(value)) {
				option.click();
				break;
			}
		}
		return this;
	}
	
	public PageBase selectByText(String fieldName, String text) {
		WebElement element = resolveForSelection(fieldName);
		
		List<WebElement> options = element.findElements(By.tagName("option"));
		
		for (WebElement option : options) {
			if (option.getText().contains(text)) {
				option.click();
				break;
			}
		}
		return this;
	}
	
	public PageBase visit(String url) {
		if (!url.startsWith("http://") || !url.startsWith("https://"))
			url = TestBase.WEB_SERVER+url.replaceAll("^/","");
		driver.navigate().to(url);
		return this;
	}

	public WebElement element(String selector) {
		return driver.findElement(By.cssSelector(selector));
	}
}
