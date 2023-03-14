package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Illustrations extends pageModel.Base{
	///paso 3///
	/// ELEMENTOS WEB////
	private By imagenes = By.xpath("//div[@type='illust']");// div[@type='illust']
	private By works = By.xpath("//span[contains(text(),'Works')]");// para seleccionar la cantidad a su costado
																	// izquierdo

	///// CONSTRUCTOR/////
	public Illustrations(WebDriver driver) {
			super.driver = driver;
			PageFactory.initElements(driver, this);
	}

	//// METODOS////
	public void ilustracionClick(String searchTag) {
		findElemento(imagenes).click();
	}

}
