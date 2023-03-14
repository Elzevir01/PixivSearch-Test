package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ImagenPresentacion extends pageModel.Base{
	///paso 4///
	/// ELEMENTOS WEB////
	private By imagen = By.xpath("//div[@type='illust']");// div[@type='illust']
	
	///// CONSTRUCTOR/////
	public ImagenPresentacion(WebDriver driver) {
			super.driver = driver;
			PageFactory.initElements(driver, this);
	}

	//// METODOS////
	public void ilustracionClick(String searchTag) {
		findElemento(imagen);
	}
}
