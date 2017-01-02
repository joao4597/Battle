/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
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
     * Test of handler method, of class ProtoX.
     */ /*
    @Test
    public void testHandler() {
        SocketServer sock = null;
        try{
            sock = new SocketServer();
        }catch(IOException e){
                
                }
        System.out.println("handler");
        String str = "##Login##";
        ProtoX instance = new ProtoX(sock);
        String expResult = "Login";
        String result = instance.handler(str);
        System.out.println(result + "dcscdsdcs");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /*
    @Test
    public void testHandler1() {
        System.out.println("handler");
        String str = "##Ranking##";
        ProtoX instance = null;
        String expResult = "Register";
        String result = instance.handler(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void testHandler2() {
        System.out.println("handler");
        String str = "##Publicity##";
        ProtoX instance = null;
        String expResult = "Publicity";
        String result = instance.handler(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void testHandler3() {
        System.out.println("##NewGame##");
        String str = "##NewGame##";
        ProtoX instance = null;
        String expResult = "NewGame";
        String result = instance.handler(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void testHandler4() {
        System.out.println("##Shot##");
        String str = "##Shot##";
        ProtoX instance = null;
        String expResult = "Shot";
        String result = instance.handler(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }   

    /**
     * Test of confirmation method, of class ProtoX.
     *//*
    @Test
    public void testConfirmation() {
        System.out.println("confirmation");
        ProtoX instance = null;
        instance.confirmation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of denied method, of class ProtoX.
     *//*
    @Test
    public void testDenied() {
        System.out.println("denied");
        ProtoX instance = null;
        instance.denied();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendShot method, of class ProtoX.
     *//*
    @Test
    public void testSendShot() {
        System.out.println("sendShot");
        String position = "";
        int i = 0;
        ProtoX instance = null;
        instance.sendShot(position, i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendResponse method, of class ProtoX.
     *//*
    @Test
    public void testSendResponse() {
        System.out.println("sendResponse");
        int i = 0;
        String death = "";
        ProtoX instance = null;
        instance.sendResponse(i, death);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gameOver method, of class ProtoX.
     *//*
    @Test
    public void testGameOver() {
        System.out.println("gameOver");
        ProtoX instance = null;
        instance.gameOver();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gameIsAlive method, of class ProtoX.
     *//*
    @Test
    public void testGameIsAlive() {
        System.out.println("gameIsAlive");
        ProtoX instance = null;
        instance.gameIsAlive();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirmationNewGame method, of class ProtoX.
     *//*
    @Test
    public void testConfirmationNewGame() {
        System.out.println("confirmationNewGame");
        String order = "";
        ProtoX instance = null;
        instance.confirmationNewGame(order);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginConfirmation method, of class ProtoX.
     *//*
    @Test
    public void testLoginConfirmation() {
        System.out.println("loginConfirmation");
        int wins = 0;
        int losses = 0;
        int points = 0;
        ProtoX instance = null;
        instance.loginConfirmation(wins, losses, points);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendRanking method, of class ProtoX.
     *//*
    @Test
    public void testSendRanking() {
        System.out.println("sendRanking");
        String rank = "";
        ProtoX instance = null;
        instance.sendRanking(rank);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendPublicity method, of class ProtoX.
     *//*
    @Test
    public void testSendPublicity() {
        System.out.println("sendPublicity");
        ProtoX instance = null;
        instance.sendPublicity();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
