package base;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.ExcelUtils;

public class TestBase {
	static ResourceBundle datosInicio = ResourceBundle.getBundle("datosInicio");
	protected static final String OS = System.getProperty("os.name").toLowerCase();
	protected static final String ARQ = System.getProperty("os.arch").toLowerCase();
	protected static final String CUR_DIR = System.getProperty("user.dir");
	protected static final String BROWSER = System.getProperty("BROWSER", datosInicio.getString("Navegador"));
	protected static final String WEB_SERVER = System.getProperty("WEB_SERVER", datosInicio.getString("Url"));
	protected static WebDriver driver;
	protected static ExcelUtils excelUtils;

	public WebDriver getDriver() {
		return driver;
	}

	private static void setupDriver(String browser, String url) {
		switch (browser) {
		case "firefox":
			driver = initFirefoxDriver(url);
			break;
		case "chrome":
			driver = initChromeDriver(url);
			break;
		case "iExplorer":
			driver = initIExplorerDriver(url);
			break;
		case "iEdge":
			driver = initIEdgeDriver(url);
			break;
		case "opera":
			driver = initOperaDriver(url);
			break;
		default:
			throw new RuntimeException("Browser type unsupported: " + browser);
		}
	}

	private static WebDriver initFirefoxDriver(String url) {
		if (OS.contains("win")) {
			System.setProperty("webdriver.gecko.driver", CUR_DIR + "/drivers/GeckoDriver/geckodriver.exe");
		} else if (OS.contains("linux")) {
			System.setProperty("webdriver.gecko.driver", CUR_DIR + "/drivers/GeckoDriver/geckodriver");
		} else if (OS.contains("mac")) {
			System.setProperty("webdriver.gecko.driver", CUR_DIR + "/drivers/GeckoDriver/geckodriver");
		}
		FirefoxOptions options = new FirefoxOptions()
				.addPreference("security.insecure_field_warning.contextual.enabled", false);
		driver = new FirefoxDriver(options);
		driver.navigate().to(url);
		return driver;
	}

	private static WebDriver initIEdgeDriver(String url) {
		if (OS.contains("win")) {
			System.setProperty("webdriver.chrome.driver",
					CUR_DIR + "/drivers/Chrome/windows/Release 15063/MicrosoftWebDriver.exe");
		} else {
			throw new RuntimeException("El navegador no es soportado.");
		}
		driver = new EdgeDriver();
		driver.navigate().to(url);
		return driver;
	}

	private static WebDriver initIExplorerDriver(String url) {
		String arquitectura = ARQ.contains("32") ? "32" : "64";
		if (OS.contains("win")) {
			System.setProperty("webdriver.chrome.driver",
					CUR_DIR + "/drivers/IExplorer/" + arquitectura + "/IEDriverServer.exe");
		} else {
			throw new RuntimeException("El navegador no es soportado.");
		}
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
		options.setCapability("ie.ensureCleanSession", true);
		options.setCapability("unexpectedAlertBehaviour", "accept");
		options.setCapability("ignoreProtectedModeSettings", true);
		options.setCapability("enablePersistentHover", true);
		options.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, url);
		driver = new InternetExplorerDriver(options);
		driver.navigate().to(url);
		return driver;
	}

	private static WebDriver initChromeDriver(String url) {
		String arquitectura = ARQ.contains("32") ? "32" : "64";
		if (OS.contains("win")) {
			System.setProperty("webdriver.chrome.driver", CUR_DIR + "/drivers/Chrome/windows/chromedriver.exe");
		} else if (OS.contains("linux")) {
			System.setProperty("webdriver.chrome.driver",
					CUR_DIR + "/drivers/Chrome/linux/" + arquitectura + "/chromedriver");
		} else if (OS.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", CUR_DIR + "/drivers/Chrome/mac/chromedriver");
		}
		driver = new ChromeDriver();
		driver.navigate().to(url);
		return driver;
	}

	private static WebDriver initOperaDriver(String url) {
		String arquitectura = ARQ.contains("32") ? "32" : "64";
		if (OS.contains("win")) {
			System.setProperty("webdriver.opera.driver", CUR_DIR + "/drivers/Opera/windows/" + arquitectura + "/operadriver.exe");
		} else if (OS.contains("linux")) {
			System.setProperty("webdriver.opera.driver", CUR_DIR + "/drivers/Opera/linux/" + arquitectura + "/operadriver");
		} else if (OS.contains("mac")) {
			System.setProperty("webdriver.opera.driver", CUR_DIR + "/drivers/Opera/mac/operadriver");
		}
		driver = new OperaDriver();
		driver.navigate().to(url);
		return driver;
	}

	public static boolean implicitWait(long time) {
		try {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@BeforeClass
	public void initializeTestBaseSetup() {
		try {
			setupDriver(BROWSER, WEB_SERVER);
			implicitWait(8);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error....." + e.getStackTrace());

		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
