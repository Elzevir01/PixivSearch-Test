package drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {
	WebDriver driver;
	public BrowserFactory() {
		
	}
	private static DriverFactory instance = new DriverFactory();
	
	private static DriverFactory getInstance() {
		return instance;
	}
	////CONFIGURACION DE CHROME DRIVER////
	public WebDriver setDriver(String browser, String nodeURL) throws MalformedURLException{
		System.out.println(nodeURL);
		ChromeOptions chrO = new ChromeOptions();
		driver = new RemoteWebDriver(new URL(nodeURL), chrO);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		return driver;
	}
	////CERRAR Y REMOVER WEBDRIVER/////
	public void removeDriver() {
		driver.close();
		driver.quit();
	}
}
