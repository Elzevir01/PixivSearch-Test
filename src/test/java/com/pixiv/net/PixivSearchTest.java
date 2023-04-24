package com.pixiv.net;

import org.testng.annotations.Test;

import drivers.BrowserFactory;
import drivers.DriverFactory;

import pageModel.PixivIllustrations;
import pageModel.PixivImgPresentacion;
import pageModel.PixivMain;
import pageModel.PixivResultados;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class PixivSearchTest {
	WebDriver driver;
	PixivMain pxm;
	PixivResultados pxr;
	PixivIllustrations pxi;
	PixivImgPresentacion pxp;
	
	BrowserFactory bf;
	boolean flag= true;
	//tag provicional
	//String tag = "gundam";
  
	@Severity(SeverityLevel.NORMAL)
	@Feature("Pixiv.net")
	@Story(">ingreso a Pixiv.net")
	@Link(name = "https://www.pixiv.net/", url = "https://www.pixiv.net/")
	@Test(dataProvider = "dp")
	@Description("Navega desde el portal de https://www.pixiv.net/ y contemplar una imagen despues de una rapida busqueda")
  public void f(String tag) {//Integer n, String s
	 //Paso1 check de titulo por primera vez en el sitio y busqueda de una tag
		 if(flag=true) {
			 pxm.checkTituloMain(tag); 
		 }
		 flag=false;
		 pxm.buscar(tag);
	 //paso2 resultado de la busqueda, checkea titulo y da click en la pestaña illustrations
		 pxr.checkTituloResultados(tag);
		 pxr.ilustracionClick();
	 //paso3 resultados filtrados por la pestaña illustration, checkea titulo y...
		 pxi.checkTituloIllustrations(tag);
		 pxi.ilustracionClick();
	 //paso4 detenerse en la imagen
		 pxp.contemplarImagen();
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {"gundam"},
      new Object[] {"glasses"},
      new Object[] {"mecha"},
      new Object[] {"Fate/GrandOrder"},
    };
  }
  @BeforeClass
  @Parameters({"browser", "nodeUrl"})
  public void beforeTest(String browser, String nodeUrl) {//String browser, String nodeUrl
	  try {
		  bf = new BrowserFactory();
		  DriverFactory.getInstance().setDriver(bf.setDriver(browser, nodeUrl));
			driver = DriverFactory.getInstance().getDriver();
	  }catch(Exception exc) {
		  exc.printStackTrace();
		  System.out.println(exc.getMessage());
	  }
	  pxm = new PixivMain(driver);
	  pxr = new PixivResultados(driver);
	  pxi = new PixivIllustrations(driver);
	  pxp = new PixivImgPresentacion(driver);
	  pxm.navegar();
	  
  }

  @AfterClass
  public void afterTest() throws InterruptedException {
	 bf.removeDriver();
  }

}
