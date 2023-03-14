package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Resultados extends pageModel.Base{
	String tituloBase = "Pictures, Images on pixiv, Japan";//#gundam 

	///paso 2///
	/// ELEMENTOS WEB////
	private By ilustracionTab = By.xpath("//div[contains(text(),'Illustration')]");//div[@type='illust']

	///// CONSTRUCTOR/////
	public Resultados(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	////METODOS////
	public void ilustracionClick(String searchTag) {
		findElemento(ilustracionTab).click();
	}
	public void checkTituloResultados(String tag){
		checkTitulo(tag, tituloBase);
	}
}
