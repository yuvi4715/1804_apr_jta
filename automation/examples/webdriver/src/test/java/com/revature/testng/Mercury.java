package com.revature.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Mercury {
	static WebDriver wd;
	String url = "http://newtours.demoaut.com/mercurywelcome.php";

	@Test
	public void openApplication(String url) {
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		wd = new ChromeDriver();
		wd.get(url);
		
	}
	
	
	
	
	
	
//  @Test (groups = {"gifted","All"})
//  public void test1() {
//	  System.out.println("runs only if the gifted group is executed");
//  }
////  @BeforeMethod
////  public void beforeMethod() {
////	  System.out.println("Before Method - mercury");
////  }
////
////  @AfterMethod
////  public void afterMethod() {
////  }
//
//  @Test (groups = {"one","All"})
//  public void test2() {
//	  System.out.println("runs only if the All group is executed");
//  }	
}
