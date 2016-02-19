/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author st_morr
 */
public class MyStackTest extends TestCase {
    
    public MyStackTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of isEmpty method, of class MyStack.
     */
    public void testIsEmpty() {
        System.out.println("isEmpty");
        MyStack instance = new MyStack();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class MyStack.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        MyStack instance = new MyStack();
        instance.push("sss");
        instance.push("ttt");
        int expResult = 2;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class MyStack.
     */
    public void testPeek() {
        System.out.println("peek");
        MyStack instance = new MyStack();
        String expResult = "";
        String result = instance.peek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pop method, of class MyStack.
     */
    public void testPop() {
        System.out.println("pop");
        MyStack instance = new MyStack();
        String expResult = "";
        String result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of push method, of class MyStack.
     */
    public void testPush() {
        System.out.println("push");
        String o = "";
        MyStack instance = new MyStack();
        instance.push(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
