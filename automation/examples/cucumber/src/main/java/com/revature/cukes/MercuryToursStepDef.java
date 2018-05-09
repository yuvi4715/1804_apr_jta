package com.revature.cukes;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pom.LogiPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MercuryToursStepDef {

	static WebDriver wd;

	@Given("^the url is opened in chrome$")
	public void the_url_is_opened_in_chrome() throws Throwable {
		openApplication();
	}

	  public static void openApplication() {
			File chrome = new File("src/main/resources/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
			wd = new ChromeDriver();
			wd.get("http://newtours.demoaut.com/mercurywelcome.php");
		}
	@When("^valid \"([^\"]*)\" and \"([^\"]*)\" are entered$")
	public void valid_and_are_entered(String arg1, String arg2) throws Throwable {
		LogiPage.user(wd).sendKeys(arg1);
		LogiPage.pass(wd).sendKeys(arg2);
		LogiPage.loginButton(wd).click();
	}

	@Then("^I should see the home page$")
	public void i_should_see_the_home_page() throws Throwable {
		System.out.println("should write a verification test for page load or to"
				+ " verify a title or any element that can confirm the page load");
		wd.close();		
	}

}
