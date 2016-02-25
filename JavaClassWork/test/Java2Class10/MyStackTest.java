/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java2Class10;
import exercise24.MyStack;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author smorrissey
 */
public class MyStackTest extends TestCase {
    
    public MyStackTest() {
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
     * Test of isEmpty method, of class MyStack.
     */
    @Ignore
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
    @Ignore
    public void testGetSize() {
        System.out.println("getSize");
        MyStack instance = new MyStack();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of peek method, of class MyStack.
     */
    @Ignore
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
    @Ignore
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
    @Test
    public void testPush() {
        System.out.println("push");
        String o = "Beijing";
        String x = "Shanghai";
        String y = "HongKong";
        MyStack instance = new MyStack();
        instance.push(o);
        assertEquals(o, instance.peek());
        instance.push(x);
        instance.push(y);
        assertEquals(y, instance.peek());
    }
    
}
