/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.List;
import model.User;
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
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testLogin1() {
        System.out.println("login");
        String username = "lopes";
        String password = "as";
        ProtoX instance = new ProtoX();
        int expResult = -1;
        int result = instance.login(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of register method, of class ProtoX.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        String username = "ola";
        String password = "as";
        ProtoX instance = new ProtoX();
        int expResult = 1;
        int result = instance.register(username, password);
        result = instance.register(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
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
     * Test of getUser method, of class ProtoX.
     *//*
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        ProtoX instance = new ProtoX();
        User expResult = null;
        User result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newGame method, of class ProtoX.
     */
    @Test
    public void testNewGame() {
        int ii;
        System.out.println("newGame");
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
        String k = "B1";
        String l = "B2";
        String m = "B3";
        String n = "B4";
        String o = "B5";
        String p = "B6";
        String q = "B8";
        ProtoX instance = new ProtoX();
        
        String result = instance.newGame(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q);
        String expResult = "##Accepted1##";
        assertEquals(expResult, result);
        
        
        for(ii=1; ii<8; ii++){
            instance.sendShot("A" + Integer.toString(ii));
            result = instance.gameState();
            assertEquals("##GameIsAlive##", result);
            result = instance.receiveShot();
            assertEquals("red", result);
            result = instance.gameState();
            assertEquals("##GameIsAlive##", result);
            assertEquals("A" + Integer.toString(ii), instance.position);
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRanking method, of class ProtoX.
     *//*
    @Test
    public void testGetRanking() {
        System.out.println("getRanking");
        ProtoX instance = new ProtoX();
        int expResult = 0;
        int result = instance.getRanking();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImagesUrl method, of class ProtoX.
     *//*
    @Test
    public void testGetImagesUrl() {
        System.out.println("getImagesUrl");
        ProtoX instance = new ProtoX();
        List<URL> expResult = null;
        List<URL> result = instance.getImagesUrl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
