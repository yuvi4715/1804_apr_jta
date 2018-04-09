// Use System.out.println( ) to note where you are in the control flow. Example: “Starting try block”, “Ending try block”, “Starting catch block”, etc.


package Exceptions;

import static org.junit.Assert.*; 

import org.junit.After;
import org.junit.Before; // for @Before
import org.junit.Test; // for @Test

public class question12 {

    private int anyObject;

    @Before
    public void initObjects() {
        anyObject = 5;
        System.out.println("Before error message");
    }

    @Test
    public void aTestUsingAnyObject() {
        // Here, anyObject is not null...
        assertNotNull(anyObject);
    }
    
    @After
    public void endObjects() {
        anyObject = 5;
        System.out.println("Before error message");
    }

    
}