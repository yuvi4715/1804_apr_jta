package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogiPage {

	private static WebElement element;
	
	public static WebElement user(WebDriver wd) {
		element = wd.findElement(By.name("userName"));
		return element;
	}
	
	public static WebElement pass(WebDriver wd) {
		element = wd.findElement(By.name("password"));
		return element;
	}
	
	public static WebElement loginButton(WebDriver wd) {
		element = wd.findElement(By.name("login"));
		return element;
	}
	
	@FindBy(xpath="//a[@href='mercurywelcome.php']")
	public WebElement homeLink;
}
