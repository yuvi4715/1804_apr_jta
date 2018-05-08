package com.revature.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class HelloTestNG {
	
  @Ignore
  @Test(dataProvider = "thisismyDataProvider", priority=1)
  public void test3(Integer n, String s) {
	  System.out.println("Value of n: " + n + ", Value of s: " + s);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
  }

  @Test (groups = {"gifted","All"})
  public void DannyRand() {
	  System.out.println("DannyRand ");
  }
  
  @Test (groups = {"gifted","All"}, priority=0)
  public void JessicaJones() {
	  System.out.println("JessicaJones");
  }
  
  @Test (groups = {"gifted","All"})
  public void CarlLucas() {
	  System.out.println("CarlLucas");
  }
  
  @Test (groups = {"gifted","All"}, priority=1)
  public void MattMurdock() {
	  System.out.println("MattMurdock");
  }
  
  @Test (groups = {"friendsofgifted","All"}, priority=1)
  public void Friend1() {
	  System.out.println("KarenPage");
	  //assertFalse(true);
  }
  
  @Test (groups = {"friendsofgifted","All"})
  public void Friend2() {
	  System.out.println("FoggyNelson");
	  //assertEquals(true, false);
  }
  
  @DataProvider
  public Object[][] thisismyDataProvider() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  
  @Test(enabled=false, priority=1)
  public void one() {
	  
  }
  @Test (expectedExceptions =NullPointerException.class)
  public void testForNullPointerException() {
	  String s1 = null;
	  System.out.println(s1.length());
  }
  
  @Test()//dependsOnMethods="Friend1")
  public void neverCreateDependencyOnOtherTests() {
	  System.out.println("These kind of tests are not best practise");
  }
  
//  @BeforeClass
//  public void beforeClass() {
//	  System.out.println("Before Class");
//  }
//
//  @AfterClass
//  public void afterClass() {
//	  System.out.println("After Class");
//  }
//
//  @BeforeTest
//  public void beforeTest() {
//	  System.out.println("Before Test");
//  }
//
//  @AfterTest
//  public void afterTest() {
//	  System.out.println("After Test");
//  }
//
//  @BeforeSuite
//  public void beforeSuite() {
//	  System.out.println("Before Suite");
//  }
//
//  @AfterSuite
//  public void afterSuite() {
//	  System.out.println("After Suite");
//  }

}
