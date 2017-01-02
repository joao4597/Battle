/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import interfacejogo.SocketClient;
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
public class SocketClientTest {
    
    public SocketClientTest() {
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
     * Test of fromServer method, of class SocketClient.
     *//*
    @Test
    public void testFromServer() {
        System.out.println("fromServer");
        SocketClient instance = new SocketClient();
        String expResult = "";
        String result = instance.fromServer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toServer method, of class SocketClient.
     *//*
    @Test
    public void testToServer() {
        System.out.println("toServer");
        String s = "";
        SocketClient instance = new SocketClient();
        instance.toServer(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeSocket method, of class SocketClient.
     */
    @Test
    public void testCloseSocket() throws Exception {
        System.out.println("closeSocket");
        SocketClient instance = null;
        try{
            instance = new SocketClient();
        }catch(IOException e){
            fail("Falhou ao ligar ao servidor");
        }
        
        instance.closeSocket();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
