/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;


import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
/**
 *
 * @author joao
 */
public class WatingListTest {
    
    public WatingListTest() {
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
     * Test of returnOrder method, of class WatingList.
     */
    @Test
    public void testReturnOrder() {
        System.out.println("returnOrder");
        SocketServer sock = null;
        List<String> lista = new ArrayList<>();
        WatingList instance = new WatingList(lista, sock, "lopes");
        instance.returnOrder();
        int expResult = 1;
        int result = instance.returnOrder();
        assertEquals(expResult, result);
        
        List<String> lista1 = new ArrayList<>();
        WatingList instance1 = new WatingList(lista, sock, "lopes");
        int expResult1 = 2;
        int result1 = instance.returnOrder();
        assertEquals(expResult1, result1);
        //TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    

    /**
     * Test of returnThread method, of class WatingList.
     *//*
    @Test
    public void testReturnThread() {
        System.out.println("returnThread");
        WatingList instance = null;
        NewGame expResult = null;
        NewGame result = instance.returnThread();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
