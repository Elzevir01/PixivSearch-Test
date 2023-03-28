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
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class PixivSearchTest {
	WebDriver driver;
	PixivMain pxm;
	PixivResultados pxr;
	PixivIllustrations pxi;
	PixivImgPresentacion pxp;
	
	BrowserFactory bf;
	//tag provicional
	String tag = "gundam";
	
  @Test//(dataProvider = "dp")
  public void f() {//Integer n, String s
	 //Paso1 Navegacion a la portada pixiv.net
	 pxm = new PixivMain(driver);
	 pxm.navegar();
	 pxm.checkTituloMain(tag);
	 pxm.buscar(tag);
	 //paso2 resultado de la busqueda, checkea titulo y da click en la pestaña illustrations
	 pxr = new PixivResultados(driver);
	 pxr.checkTituloResultados(tag);
	 pxr.ilustracionClick();
	 //paso3 resultados filtrados por la pestaña illustration, checkea titulo y...
	 pxi = new PixivIllustrations(driver);
	 pxi.checkTituloIllustrations(tag);
	 pxi.ilustracionClick();
	 //paso4 descarga imagen
	 pxp = new PixivImgPresentacion(driver);
	 //pxp.descargarImagen2();
	 //pxp.abrirImagen();
	 pxp.contemplarImagen();
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {"gundam"},
      new Object[] {"glasses"},
    };
  }
  @BeforeTest
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
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	 bf.removeDriver();
  }

}
