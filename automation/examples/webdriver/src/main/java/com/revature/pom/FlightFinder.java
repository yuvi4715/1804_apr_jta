package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightFinder {

	private static WebElement element;
	
	public static WebElement departingFrom(WebDriver wd) {
		element = wd.findElement(By.name("fromPort"));
		return element;
	}
	
	public static WebElement airline(WebDriver wd) {
		element = wd.findElement(By.name("airline"));
		return element;
	}
	
	public static WebElement findFlightsBtn(WebDriver wd) {
		element = wd.findElement(By.name("findFlights"));
		return element;
	}
}
