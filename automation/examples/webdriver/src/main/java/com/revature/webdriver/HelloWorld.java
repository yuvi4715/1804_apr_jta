package com.revature.webdriver;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import net.bytebuddy.asm.Advice.Return;

public class HelloWorld {

	public static void main(String[] args) {
		//openChrome();
		openFirefox();
	}
	
	static void openFirefox(){
		File firefox = new File("src/main/resources/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", firefox.getAbsolutePath());
		WebDriver d = new FirefoxDriver();
		d.get("http://www.google.com");
		d.findElement(By.id("lst-ib")).sendKeys("SDET");
		d.findElement(By.id("lst-ib")).sendKeys(Keys.RETURN);
		//d.close();
		d.quit();
	}
	
	static void openChrome(){
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		WebDriver d = new ChromeDriver();
		d.get("http://www.google.com");
		d.close();
	}

}
