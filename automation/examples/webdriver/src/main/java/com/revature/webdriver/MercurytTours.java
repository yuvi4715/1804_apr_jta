package com.revature.webdriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercurytTours {
	static WebDriver wd;
	public static void main(String[] args) {
		openApplication();
		verifyPageTitle();
		login();
		findFlights();
		logout();
	}
	static void openApplication() {
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		wd = new ChromeDriver();
		wd.get("http://newtours.demoaut.com/mercurywelcome.php");
	}
	
	static void verifyPageTitle() {
		//wd.wait(10);			//explicit wait
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualTitle = wd.getTitle();
		String expectedTitle = "Welcome: Mercury Tours";
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Actual title matched with expected title :" + expectedTitle);
		} else
			System.out.println("Actual title does not match with expected title");
	}
	static void login() {
		wd.findElement(By.name("userName")).sendKeys("test1");
		wd.findElement(By.xpath("//input[@name='password']")).sendKeys("test1");
		wd.findElement(By.name("login")).click();
	}
	static void findFlights() {
		wd.findElement(By.name("fromPort")).sendKeys("Frankfurt");
		wd.findElement(By.name("airline")).sendKeys("Blue Skies Airlines");
		wd.findElement(By.name("findFlights")).click();
	}
	static void logout() {
		wd.findElement(By.xpath("//a[@href='mercurysignoff.php']")).click();
		wd.close();
	}
}
