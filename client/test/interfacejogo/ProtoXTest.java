/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacejogo;

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
public class ProtoXTest {
    
    public ProtoXTest() {
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
     * Test of login method, of class ProtoX.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "lopes";
        String password = "as";
        ProtoX instance = new ProtoX();
        int expResult = 0;
        int result = instance.login(username, password);
        assertEquals(expResult, result);
        
        System.out.println("login");
        String username1 = "lopes";
        String password1 = "as";
        ProtoX instance1 = new ProtoX();
        int expResult1 = 1;
        int result1 = instance.login(username1, password1);
        assertEquals(expResult1, result1);

    }

    /**
     * Test of register method, of class ProtoX.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        String username = "lopes";
        String password = "as";
        ProtoX instance = new ProtoX();
        int expResult = 1;
        int result = instance.register(username, password);
        assertEquals(expResult, result);

    }

    /**
     * Test of sendShot method, of class ProtoX.
     *//*
    @Test
    public void testSendShot() {
        System.out.println("sendShot");
        String position = "";
        ProtoX instance = new ProtoX();
        String expResult = "";
        String result = instance.sendShot(position);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of receiveShot method, of class ProtoX.
     *//*
    @Test
    public void testReceiveShot() {
        System.out.println("receiveShot");
        ProtoX instance = new ProtoX();
        String expResult = "";
        String result = instance.receiveShot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gameState method, of class ProtoX.
     *//*
    @Test
    public void testGameState() {
        System.out.println("gameState");
        ProtoX instance = new ProtoX();
        String expResult = "";
        String result = instance.gameState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class ProtoX.
     *//*
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        ProtoX instance = new ProtoX();
        String expResult = "";
        String result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newGame method, of class ProtoX.
     *//*
    @Test
    public void testNewGame() {
        
        System.out.println("newGame1");
        String a = "A1";
        String b = "A2";
        String c = "A3";
        String d = "A4";
        String e = "A5";
        String f = "A6";
        String g = "A7";
        String h = "A8";
        String i = "A9";
        String j = "A10";
        String k = "A11";
        String l = "A12";
        String m = "A13";
        String n = "A14";
        String o = "A15";
        String p = "A16";
        String q = "A17";
        ProtoX instance = new ProtoX();
        String expResult = "##Accepted";
        String result = instance.newGame(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q);
        //assertEquals(expResult, result.substring(0, result.indexOf("##") - 1));
        
        
        System.out.println("newGame2");
        String a1 = "A1";
        String b1 = "A2";
        String c1 = "A3";
        String d1 = "A4";
        String e1 = "A5";
        String f1 = "A6";
        String g1 = "A7";
        String h1 = "A8";
        String i1 = "A9";
        String j1 = "A10";
        String k1 = "A11";
        String l1 = "A12";
        String m1 = "A13";
        String n1 = "A14";
        String o1 = "A15";
        String p1 = "A16";
        String q1 = "A17";
        ProtoX instance1 = new ProtoX();
        String expResult1 = "##Accepted";
        String result1 = instance.newGame(a1, b1, c1, d1, e1, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1, q1);
        assertEquals(expResult1, result1.substring(0, result1.indexOf("##") - 1));
        
        
        
                
        // TODO review the generated test code and remove the default1 call to fail.
        //fail("The test case is a prototype.");
    }   */
}
