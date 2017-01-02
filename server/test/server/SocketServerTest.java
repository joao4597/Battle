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
public class SocketServerTest {
    
    public SocketServerTest() {
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
     * Test of fromClient method, of class SocketServer.
     * @throws java.io.IOException
     */
    @Test
    public void testFromClient() throws IOException{
        System.out.println("fromClient");
        SocketServer instance = new SocketServer();
        String expResult = "##Login##";
        String result = instance.fromClient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toClient method, of class SocketServer.
     *//*
    @Test
    public void testToClient() {
        System.out.println("toClient");
        String s = "";
        SocketServer instance = new SocketServer();
        instance.toClient(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class SocketServer.
     */
    @Test
    public void testClose() throws Exception {
        System.out.println("close");
        SocketServer instance = new SocketServer();
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
