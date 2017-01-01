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
public class RankingDBTest {
    
    public RankingDBTest() {
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
     * Test of getRanking method, of class RankingDB.
     */
    @Test
    public void testGetRanking() {
        System.out.println("getRanking");
        RankingDB instance = new RankingDB();
        
        String result = instance.getRanking();
        int expResult;
        if(result.contains("lopes"))
            expResult = 1;
        else
            expResult = 0;
        
        assertEquals(expResult, 1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
