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
 *Class usada para adicionar pontos a jogador
 * @author joao
 */
public class AddPointsDBTest {
    
    public AddPointsDBTest() {
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
     * Test of addPoints method, of class AddPointsDB.
     */
    @Test
    public void testAddPoints() {
        System.out.println("addPoints");
        String username = "lopes";
        int points = 100;
        AddPointsDB instance = new AddPointsDB();
        instance.addPoints(username, points);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
