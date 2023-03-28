package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import js.jScript;

public class PixivResultados extends pageModel.Base{
	String tituloBase = "Drawings, Best Fan Art on pixiv, Japan";//#gundam 
	jScript js = new jScript();
	///paso 2///
	
	/// ELEMENTOS WEB////
	//pestaña ilustracion
	private By ilustracionTab = By.xpath("//div[contains(text(),'Illustration')]");//div[@type='illust']

	///// CONSTRUCTOR/////
	public PixivResultados(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	////METODOS////
	public void ilustracionClick() {
		esperarElemento(ilustracionTab);
		findElemento(ilustracionTab).click();
		js.waitForPageToLoad(driver);
		//esperarPaginaWeb("https://www.pixiv.net/en/tags/gundam/illustrations");
	}
	public void checkTituloResultados(String tag){
		checkTitulo(tag, tituloBase);
	}
}
