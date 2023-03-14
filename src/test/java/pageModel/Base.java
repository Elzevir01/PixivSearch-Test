package pageModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	WebDriver driver;

	///// CONSTRUCTOR/////
	public Base(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public Base() {
	}
	
	////METODOS/////

	////trae el webelement para rapido acceso
	public WebElement findElemento(By elemento) {
		return driver.findElement(elemento);
	}
	////click en el elemento
	public void clickElemento(By elemento) {
		driver.findElement(elemento).click();
	}
	////coloca texto a un elemento web y lo envia
	public void sendKey(By elemento, String texto) {
		findElemento(elemento).sendKeys(texto);
	}
	////limpia el texto de un elemento web
	public void clearText(By elemento) {
		findElemento(elemento).clear();
	}
	////scroll hacia un elemento web
	public void cursorTo(By elemento) {
		new Actions(driver).moveToElement(findElemento(elemento)).perform();
	}
	////navega hacia una pagina web
	public void navegar(String url) {
		driver.get(url);
	}
	////navega hacia una pagina web PARA OVERRIDE
	public void navegar() {
	}
	////obtiene el titulo de la web actual
	public String titulo() {
		return driver.getTitle();
	}
	////validacion del titulo
	public void confirmarTitulo(String titulo) {
		ExpectedConditions.titleIs(titulo);
	}
	////////////////////////////////////////////////////////////////
	public void checkTitulo(String tag, String tituloFijo){
		String expectativa = "#"+tag+" "+tituloFijo;
		try{
			System.out.println("titulo Expectativa: "+expectativa);
			System.out.println("titulo Actual: "+titulo());
			confirmarTitulo(expectativa);

		}catch(Exception e){
			e.getMessage();
		}
	}
	////espera la carga de un elemento
	public void esperarElemento(By elemento) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));	
	}
	////valida si un elemento existe o no(true/false)
	public boolean checkElement(By elemento) {
	    try {
	    	if (findElemento(elemento).isDisplayed()) {
	    		System.out.println("Element exist");
			}
	    	return true;
	    }catch(org.openqa.selenium.NoSuchElementException e) {
	    	System.out.println("Element NO exist");
	    	return false;
	    }
	}
}
