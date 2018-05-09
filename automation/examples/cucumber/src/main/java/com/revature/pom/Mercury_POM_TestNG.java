package com.revature.pom;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Mercury_POM_TestNG {
	
  static WebDriver wd;
  
  @Test(priority=0)
  public void VerifyValidLogin() {
	  openApplication();
	  LogiPage.user(wd).sendKeys("test1");
	  LogiPage.pass(wd).sendKeys("test1");
	  LogiPage.loginButton(wd).click();
  }
  
  @Test(priority=1)
  public void VerifyFindingFlights() {
	  FlightFinder.departingFrom(wd).sendKeys("London");
	  FlightFinder.airline(wd).sendKeys("airlines");
	  FlightFinder.findFlightsBtn(wd).click();
  }
  
  public static void openApplication() {
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		wd = new ChromeDriver();
		wd.get("http://newtours.demoaut.com/mercurywelcome.php");
	}
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
	  wd.close();
  }

}
