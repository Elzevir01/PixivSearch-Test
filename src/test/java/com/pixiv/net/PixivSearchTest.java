package com.pixiv.net;

import org.testng.annotations.Test;

import drivers.BrowserFactory;
import drivers.DriverFactory;
import pageModel.PixivMain;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class PixivSearchTest {
	WebDriver driver;
	PixivMain pxm;
	BrowserFactory bf;
	
  @Test //(dataProvider = "dp")
  public void f() {//Integer n, String s
	  ///Navegacion a la portada pixiv.net
	 pxm = new PixivMain(driver);
	 pxm.navegar();
	 pxm.buscar("gundam");
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
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
