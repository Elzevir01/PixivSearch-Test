package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import js.jScript;

public class PixivMain extends pageModel.Base{
	jScript js = new jScript();
	///paso 1///
	////VARIABLES////
	String web = "https://www.pixiv.net/en/";
	String tituloBase = "Online community for artists [pixiv]";
	
	////ELEMENTOS WEB////
	private By buscador = By.xpath("//input[@type = 'text']");
	
	///CONTRUCTOR////
	public PixivMain(WebDriver driver) {
		super.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	////METODOS////
	//Envia el Tag en el buscador e inicia la busqueda
	public void buscar(String searchTag) {
		esperarElemento(buscador);
		findElemento(buscador).sendKeys(searchTag);
		findElemento(buscador).sendKeys(Keys.ENTER);
		js.waitForPageToLoad(driver);
		//esperarPaginaWeb("https://www.pixiv.net/en/tags/gundam");
	}
	//Navega hacia https://pixiv.net/en/
	@Override
	public void navegar() {
		driver.get(web);
		js.waitForPageToLoad(driver);
	}
	public void checkTituloMain(String tag){
		checkTitulo(tag, tituloBase);
	}
}
