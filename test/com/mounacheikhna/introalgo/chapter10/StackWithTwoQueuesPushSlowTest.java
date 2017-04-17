package com.mounacheikhna.introalgo.chapter10;

import java.util.NoSuchElementException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by m.cheikhna on 17/04/2017.
 */
public class StackWithTwoQueuesPushSlowTest {

    @Test
    public void testPush() {
        StackWithTwoQueuesPushSlow<String> stack = new StackWithTwoQueuesPushSlow<String>();
        stack.push("b");
        assertEquals("b", stack.pop());
    }

    @Test
    public void testPushMany() {
        StackWithTwoQueuesPushSlow<String> stack = new StackWithTwoQueuesPushSlow<String>();
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
        StackWithTwoQueuesPushSlow<String> stack = new StackWithTwoQueuesPushSlow<String>();
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
        StackWithTwoQueuesPushSlow<String> stack = new StackWithTwoQueuesPushSlow<String>();
        stack.push("b");
        stack.pop();
        stack.pop();
    }

    @Test
    public void testPopMany() {
        StackWithTwoQueuesPushSlow<String> stack = new StackWithTwoQueuesPushSlow<String>();
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
