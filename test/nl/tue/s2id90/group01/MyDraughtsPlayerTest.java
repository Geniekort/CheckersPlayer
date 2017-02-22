/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.s2id90.group01;

import java.util.ArrayList;
import nl.tue.s2id90.draughts.DraughtsState;
import org.junit.Test;
import static org.junit.Assert.*;
import org10x10.dam.game.Move;

/**
 *
 * @author D Kortleven
 */
public class MyDraughtsPlayerTest {
    
    public MyDraughtsPlayerTest() {
    }

//    /**
//     * Test of getMove method, of class MyDraughtsPlayer.
//     */
//    @Test
//    public void testGetMove() {
//        System.out.println("getMove");
//        DraughtsState s = null;
//        MyDraughtsPlayer instance = null;
//        Move expResult = null;
//        Move result = instance.getMove(s);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getValue method, of class MyDraughtsPlayer.
//     */
//    @Test
//    public void testGetValue() {
//        System.out.println("getValue");
//        MyDraughtsPlayer instance = null;
//        Integer expResult = null;
//        Integer result = instance.getValue();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of stop method, of class MyDraughtsPlayer.
//     */
//    @Test
//    public void testStop() {
//        System.out.println("stop");
//        MyDraughtsPlayer instance = null;
//        instance.stop();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRandomValidMove method, of class MyDraughtsPlayer.
//     */
//    @Test
//    public void testGetRandomValidMove() {
//        System.out.println("getRandomValidMove");
//        DraughtsState s = null;
//        MyDraughtsPlayer instance = null;
//        Move expResult = null;
//        Move result = instance.getRandomValidMove(s);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of alphaBeta method, of class MyDraughtsPlayer.
//     */
//    @Test
//    public void testAlphaBeta() throws Exception {
//        System.out.println("alphaBeta");
//        DraughtsNode node = null;
//        int alpha = 0;
//        int beta = 0;
//        int depth = 0;
//        MyDraughtsPlayer instance = null;
//        int expResult = 0;
//        int result = instance.alphaBeta(node, alpha, beta, depth);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of alphaBetaMin method, of class MyDraughtsPlayer.
//     */
//    @Test
//    public void testAlphaBetaMin() throws Exception {
//        System.out.println("alphaBetaMin");
//        DraughtsNode node = null;
//        int alpha = 0;
//        int beta = 0;
//        int depth = 0;
//        MyDraughtsPlayer instance = null;
//        int expResult = 0;
//        int result = instance.alphaBetaMin(node, alpha, beta, depth);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of alphaBetaMax method, of class MyDraughtsPlayer.
//     */
//    @Test
//    public void testAlphaBetaMax() throws Exception {
//        System.out.println("alphaBetaMax");
//        DraughtsNode node = null;
//        int alpha = 0;
//        int beta = 0;
//        int depth = 0;
//        MyDraughtsPlayer instance = null;
//        int expResult = 0;
//        int result = instance.alphaBetaMax(node, alpha, beta, depth);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of evaluate method, of class MyDraughtsPlayer.
//     */
//    @Test
//    public void testEvaluate() {
//        System.out.println("evaluate");
//        DraughtsState state = null;
//        MyDraughtsPlayer instance = null;
//        int expResult = 0;
//        int result = instance.evaluate(state);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of clusterScore method, of class MyDraughtsPlayer.
//     */
//    @Test
//    public void testClusterScore() {
//        System.out.println("clusterScore");
//        DraughtsState s = null;
//        MyDraughtsPlayer instance = null;
//        int expResult = 0;
//        int result = instance.clusterScore(s);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of isWhite method, of class MyDraughtsPlayer.
//     */
//    @Test
//    public void testIsWhite() {
//        System.out.println("isWhite");
//        int q = 0;
//        MyDraughtsPlayer instance = null;
//        boolean expResult = false;
//        boolean result = instance.isWhite(q);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of isBlack method, of class MyDraughtsPlayer.
//     */
//    @Test
//    public void testIsBlack() {
//        System.out.println("isBlack");
//        int q = 0;
//        MyDraughtsPlayer instance = null;
//        boolean expResult = false;
//        boolean result = instance.isBlack(q);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of transformField method, of class MyDraughtsPlayer.
//     */
//    @Test
//    public void testTransformField() {
//        System.out.println("transformField");
//        int[] initF = null;
//        MyDraughtsPlayer instance = null;
//        int[][] expResult = null;
//        int[][] result = instance.transformField(initF);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of adjacentPlaces method, of class MyDraughtsPlayer.
     */
    @Test
    public void testAdjacentPlaces() {
        System.out.println("adjacentPlaces");
        int x = 2;
        int y = 1;
        MyDraughtsPlayer instance = new MyDraughtsPlayer(5);
        ArrayList<int[]> expResult = null;
        ArrayList<int[]> result = instance.adjacentPlaces(x, y);
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i)[0] + " " + result.get(i)[1]);
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

//    /**
//     * Test of isInBound method, of class MyDraughtsPlayer.
//     */
//    @Test
//    public void testIsInBound() {
//        System.out.println("isInBound");
//        int i = 0;
//        int j = 0;
//        MyDraughtsPlayer instance = null;
//        boolean expResult = false;
//        boolean result = instance.isInBound(i, j);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
