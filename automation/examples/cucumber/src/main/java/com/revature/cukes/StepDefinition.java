package com.revature.cukes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

	@Given("^there are cucumbers$")
	public void there_are_cucumbers() throws Throwable {
	    //throw new PendingException();
		System.out.println("simple print statement for given");
	}

	@When("^I am hungry$")
	public void i_am_hungry() throws Throwable {
	    //throw new PendingException();
		System.out.println("simple print statement for when");
	}

	@Then("^I eat cucumbers$")
	public void i_eat_cucumbers() throws Throwable {
	    //throw new PendingException();
		System.out.println("simple print statement for then");
	}
}
