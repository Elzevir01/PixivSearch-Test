package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PixivMain extends pageModel.Base{
	///paso 1///
	////VARIABLES////
	String web = "https://www.pixiv.net/en/";
	
	////ELEMENTOS WEB////
	private By buscador = By.xpath("//input[@type = 'text']");
	
	///CONTRUCTOR////
	public PixivMain(WebDriver driver) {
		super.driver =driver;
		PageFactory.initElements(driver, this);
	}
	////METODOS////
	public void buscar(String searchTag) {
		findElemento(buscador).sendKeys(searchTag);
		findElemento(buscador).sendKeys(Keys.ENTER);
	}
	@Override
	public void navegar() {
		driver.get(web);
	}
}
