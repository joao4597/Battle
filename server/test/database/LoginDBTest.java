/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joao
 */
public class LoginDBTest {
    
    public LoginDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of confirmeLogin method, of class LoginDB.
     */
    @Test
    public void testConfirmeLogin() {
        System.out.println("confirmeLogin");
        String username = "lopes";
        String password = "ola";
        LoginDB instance = new LoginDB();
        boolean expResult = false;
        boolean result = instance.confirmeLogin(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testConfirmeLogin1() {
        System.out.println("confirmeLogin");
        String username = "lopes";
        String password = "as";
        LoginDB instance = new LoginDB();
        boolean expResult = false;
        boolean result = instance.confirmeLogin(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
