package com.serhiihoncar.datastructures.queue;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {

    @Test
    public void testEnqueueAndDequeueWorkCorrectAndChangeSize() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        assertEquals(2, arrayQueue.size());

        assertEquals("A", arrayQueue.dequeue());
        assertEquals("B", arrayQueue.dequeue());
        assertEquals(0, arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testEnqueueAndPeek() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertEquals(2, arrayQueue.size());

        assertEquals("A", arrayQueue.peek());
        assertEquals("A", arrayQueue.peek());

        assertEquals(2, arrayQueue.size());
    }

    @Test
    public void testEnqueueAndDequeue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertEquals("A", arrayQueue.dequeue());
        assertEquals("B", arrayQueue.dequeue());

        arrayQueue.enqueue("D");
        arrayQueue.enqueue("C");

        assertEquals("D", arrayQueue.dequeue());
        assertEquals("C", arrayQueue.dequeue());

        assertEquals(0, arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnNewQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnQueueWithData() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        assertFalse(arrayQueue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnQueueAfterClear() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        assertTrue(arrayQueue.contains(new String("A")));

    }

    @Test
    public void testContainsReturnFalse() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        assertFalse(arrayQueue.contains("C"));
    }

    @Test
    public void testContainsReturnFalseOnEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertFalse(arrayQueue.contains("A"));
    }

    @Test
    public void testReturnTrueAfterClearQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");
        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testAfterEnqueueToArrayQueueIsEmptyReturnFalse(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        assertFalse(arrayQueue.isEmpty());
    }

    @Test
    public void testReturnTrueIfQueueContainsElementOnTheEndArrayQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("D");
        arrayQueue.enqueue("E");

        assertTrue(arrayQueue.contains("E"));
    }

    @Test
    public void testReturnTrueIfQueueContainsFirstElementOnTheArrayQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("D");
        arrayQueue.enqueue("E");

        assertTrue(arrayQueue.contains("A"));
    }

    @Test
    public void testReturnTrueIfQueueContainsSecondElementOnTheArrayQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("D");
        arrayQueue.enqueue("E");

        assertTrue(arrayQueue.contains("B"));
    }

    @Test
    public void testThrowIllegalStateExceptionWhenDequeueOnEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayQueue.dequeue();
        });
    }

    @Test
    public void testThrowIllegalStateExceptionWhenPeekOnEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayQueue.peek();
        });
    }


    @Test
    public void testThrowNullPointExceptionOnNull() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertThrows(NullPointerException.class, () -> {
            arrayQueue.enqueue(null);
        });

        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testPushOverInitialCapacity() {
        ArrayQueue arrayQueue = new ArrayQueue(2);
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");

        assertEquals(3, arrayQueue.size());

        assertEquals("A", arrayQueue.dequeue());
        assertEquals("B", arrayQueue.dequeue());
        assertEquals("C", arrayQueue.dequeue());

        assertEquals(0, arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testPushOverInitialCapacityVarTwo() {
        ArrayQueue arrayQueue = new ArrayQueue();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
        }

        assertEquals(10, arrayQueue.size());
        for (int i = 0; i < 10; i++) {
            System.out.println(arrayQueue.dequeue());
        }
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(arrayQueue.dequeue());
        }
        assertEquals(0, arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testToString() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");
        assertEquals("[A, B, C]", arrayQueue.toString());
    }

    @Test
    public void testToStringIsEmpty() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertEquals("[]", arrayQueue.toString());
    }

}
