package pageModel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import js.jScript;

public class PixivImgPresentacion extends pageModel.Base {
	jScript js = new jScript();
	/// paso 4///
	/// ELEMENTOS WEB////
	private By presentacionImagen = By.xpath("//div[@role='presentation']//div//div//div//img");

	///// CONSTRUCTOR/////
	public PixivImgPresentacion(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//// METODOS////
	/*
	 * public void ilustracionClick(String searchTag) {
	 * findElemento(presentacionImagen); }
	 */
	public void descargarImagen() {
		esperarElemento(presentacionImagen);
		try {
			String src = findElemento(presentacionImagen).getAttribute("src");
			BufferedImage bufferedImage = ImageIO.read(new URL(src));
			File outputfile = new File("saved.png");
			ImageIO.write(bufferedImage, "png", outputfile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void descargarImagen2() {
		esperarElemento(presentacionImagen);
		try {
			WebElement img = findElemento(presentacionImagen);
			String logoSRC = img.getAttribute("src");
			URL imageURL = new URL(logoSRC);
			BufferedImage saveImage = ImageIO.read(imageURL);
			ImageIO.write(saveImage, "png", new File("image.png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void abrirImagen() {
		esperarElemento(presentacionImagen);
		WebElement img = findElemento(presentacionImagen);
		String imagenSRC = img.getAttribute("src");
		//navegar(imagenSRC);
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		//driver.findElement(By.linkText("imagenSRC")).sendKeys(selectLinkOpeninNewTab);
		img.sendKeys(selectLinkOpeninNewTab);
		try {
			Thread.sleep(Duration.ofMinutes(1));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void contemplarImagen() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
