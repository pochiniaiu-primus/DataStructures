package com.serhiihoncar.datastructures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * void push(Object value);
 * Object pop();
 * Object peek();
 * boolean contains(Object value);
 * int size();
 * boolean isEmpty();
 * void clear();
 */
public class ArrayStackTest {

    @Test
    public void testPushAndPopWorkCorrectAndChangeSize() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("A");
        arrayStack.push("B");
        assertEquals(2, arrayStack.size());

        assertEquals("B", arrayStack.pop());
        assertEquals("A", arrayStack.pop());
        assertEquals(0, arrayStack.size());
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    public void testPushAndPeek() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("A");
        arrayStack.push("B");
        assertEquals(2, arrayStack.size());

        assertEquals("B", arrayStack.peek());
        assertEquals("B", arrayStack.peek());
        assertEquals(2, arrayStack.size());
    }

    @Test
    public void testIsEmptyReturnTrueOnNewStack() {
        ArrayStack arrayStack = new ArrayStack();
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnStackWithData() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("A");
        assertFalse(arrayStack.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnStackAfterClear() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("A");
        arrayStack.push("B");
        arrayStack.clear();
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("A");
        arrayStack.push("B");
        assertTrue(arrayStack.contains(new String("A")));

    }

    @Test
    public void testContainsReturnFalse() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("A");
        arrayStack.push("B");
        assertFalse(arrayStack.contains("C"));
    }

    @Test
    public void testContainsReturnFalseOnEmptyStack() {
        ArrayStack arrayStack = new ArrayStack();
        assertFalse(arrayStack.contains("A"));
    }

    @Test
    public void testThrowIllegalStateExceptionWhenPopOnEmptyStack() {
        ArrayStack arrayStack = new ArrayStack();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayStack.pop();
        });
    }

    //    @Test
//    public void testPushOverInitialCapacity() {
//        ArrayStack arrayStack = new ArrayStack();
//        for (int i = 0; i < 15; i++) {
//            arrayStack.push(i);
//        }
//
//        assertEquals(15, arrayStack.size());
//
//        for (int i = 14; i >= 0; i--) {
//            assertEquals(i, arrayStack.pop());
//        }
//        assertEquals(0, arrayStack.size());
//        assertTrue(arrayStack.isEmpty());
//    }
    @Test
    public void testPushOverInitialCapacity() {
        ArrayStack arrayStack = new ArrayStack(2);
        arrayStack.push("A");
        arrayStack.push("B");
        arrayStack.push("C");

        assertEquals(3, arrayStack.size());

        assertEquals("C", arrayStack.pop());
        assertEquals("B", arrayStack.pop());
        assertEquals("A", arrayStack.pop());

        assertEquals(0, arrayStack.size());
        assertTrue(arrayStack.isEmpty());
    }

}