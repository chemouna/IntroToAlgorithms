package com.mounacheikhna.introalgo.chapter10;

import java.util.NoSuchElementException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by m.cheikhna on 17/04/2017.
 */
public class StackWithTwoQueuesPopSlowTest {

    @Test
    public void testPush() {
        StackWithTwoQueuesPopSlow<String> stack = new StackWithTwoQueuesPopSlow<String>();
        stack.push("b");
        assertEquals("b", stack.pop());
    }

    @Test
    public void testPushMany() {
        StackWithTwoQueuesPopSlow<String> stack = new StackWithTwoQueuesPopSlow<String>();
        stack.push("b");
        stack.push("b");
        stack.push("b");
        stack.push("b");
        stack.push("b");
        stack.push("b");
        stack.push("b");
        stack.push("c");
        assertEquals("c", stack.pop());
    }

    @Test
    public void testPushTooMany() {
        StackWithTwoQueuesPopSlow<String> stack = new StackWithTwoQueuesPopSlow<String>();
        stack.push("b");
        stack.push("b");
        stack.push("b");
        stack.push("b");
        stack.push("b");
        stack.push("b");
        stack.push("b");
        stack.push("c");
        stack.push("b");
        stack.push("b");
        stack.push("b");
        stack.push("c");
        assertEquals("c", stack.pop());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPop() {
        StackWithTwoQueuesPopSlow<String> stack = new StackWithTwoQueuesPopSlow<String>();
        stack.push("b");
        stack.pop();
        stack.pop();
    }

    @Test
    public void testPopMany() {
        StackWithTwoQueuesPopSlow<String> stack = new StackWithTwoQueuesPopSlow<String>();
        stack.push("a");
        stack.push("b");
        stack.push("b");
        stack.push("b");
        stack.push("b");
        stack.push("b");
        stack.push("b");
        stack.push("c");
        stack.push("b");
        stack.push("b");
        stack.push("b");
        stack.push("c");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        assertEquals("a", stack.pop());
    }

}
