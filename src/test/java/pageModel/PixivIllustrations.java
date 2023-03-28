package pageModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import js.jScript;

public class PixivIllustrations extends pageModel.Base{
	jScript js = new jScript();
	///paso 3//
	
	String tituloBase = "Pictures, Images on pixiv, Japan";//#gundam 

	/// ELEMENTOS WEB////
	private By imagen = By.xpath("//section[2]//div//ul//li//div//div[@type='illust']");//reemplazado por List
	private By works = By.xpath("//span[contains(text(),'Works')]");// para seleccionar la cantidad a su costado izquierdo

	///// CONSTRUCTOR/////
	public PixivIllustrations(WebDriver driver) {
			super.driver = driver;
			PageFactory.initElements(driver, this);
	}

	//// METODOS////
	public void ilustracionClick() {
		List<WebElement> listaImagenes = driver.findElements(By.cssSelector("div>ul>li>div"));
		System.out.println(listaImagenes.size());
		listaImagenes.get(numeroRandom(1,listaImagenes.size())).click();
		js.waitForPageToLoad(driver);
		try {
			Thread.sleep(10000);
		}catch(Exception e) {
			e.getMessage();
		}
	}
	public void checkTituloIllustrations(String tag){
		checkTitulo(tag, tituloBase);
	}
	
}
