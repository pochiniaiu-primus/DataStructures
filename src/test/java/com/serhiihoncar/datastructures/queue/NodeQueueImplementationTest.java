package com.serhiihoncar.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeQueueImplementationTest {
    @Test
    public void testEnqueueAndDequeueWorkCorrectAndChangeSize() {
        NodeQueueImplementation nodeQueueImplementation = new NodeQueueImplementation();
        nodeQueueImplementation.enqueue("A");
        nodeQueueImplementation.enqueue("B");
        assertEquals(2, nodeQueueImplementation.size());

        assertEquals("A", nodeQueueImplementation.dequeue());
        assertEquals("B", nodeQueueImplementation.dequeue());
        assertEquals(0, nodeQueueImplementation.size());
        assertTrue(nodeQueueImplementation.isEmpty());

    }

    @Test
    public void testEnqueueAndTop() {
        NodeQueueImplementation nodeQueueImplementation = new NodeQueueImplementation();
        nodeQueueImplementation.enqueue("A");
        nodeQueueImplementation.enqueue("B");

        assertEquals(2, nodeQueueImplementation.size());

        assertEquals("A", nodeQueueImplementation.top());
        assertEquals("A", nodeQueueImplementation.top());

        assertEquals(2, nodeQueueImplementation.size());
    }

    @Test
    public void testEnqueueAndDequeue() {
        NodeQueueImplementation nodeQueueImplementation = new NodeQueueImplementation();
        nodeQueueImplementation.enqueue("A");
        nodeQueueImplementation.enqueue("B");

        assertEquals("A", nodeQueueImplementation.dequeue());
        assertEquals("B", nodeQueueImplementation.dequeue());

        nodeQueueImplementation.enqueue("D");
        nodeQueueImplementation.enqueue("C");

        assertEquals("D", nodeQueueImplementation.dequeue());
        assertEquals("C", nodeQueueImplementation.dequeue());

        assertEquals(0, nodeQueueImplementation.size());
        assertTrue(nodeQueueImplementation.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnNewQueue() {
        NodeQueueImplementation nodeQueueImplementation = new NodeQueueImplementation();
        assertTrue(nodeQueueImplementation.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnQueueWithData() {
        NodeQueueImplementation nodeQueueImplementation = new NodeQueueImplementation();
        nodeQueueImplementation.enqueue("A");
        assertFalse(nodeQueueImplementation.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnQueueAfterClear() {
        NodeQueueImplementation nodeQueueImplementation = new NodeQueueImplementation();
        nodeQueueImplementation.enqueue("A");
        nodeQueueImplementation.enqueue("B");
        nodeQueueImplementation.clear();
        assertTrue(nodeQueueImplementation.isEmpty());
    }

    @Test
    public void testReturnTrueAfterClearQueue() {
        NodeQueueImplementation nodeQueueImplementation = new NodeQueueImplementation();
        nodeQueueImplementation.enqueue("A");
        nodeQueueImplementation.enqueue("B");
        nodeQueueImplementation.enqueue("C");
        nodeQueueImplementation.clear();
        assertTrue(nodeQueueImplementation.isEmpty());
    }

    @Test
    public void testThrowIllegalStateExceptionWhenDequeueOnEmptyQueue() {
        NodeQueueImplementation nodeQueueImplementation = new NodeQueueImplementation();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            nodeQueueImplementation.dequeue();
        });
    }

    @Test
    public void testThrowIllegalStateExceptionWhenTopOnEmptyQueue() {
        NodeQueueImplementation nodeQueueImplementation = new NodeQueueImplementation();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            nodeQueueImplementation.top();
        });
    }
    @Test
    public void testToString() {
        NodeQueueImplementation nodeQueueImplementation = new NodeQueueImplementation();
        nodeQueueImplementation.enqueue("A");
        nodeQueueImplementation.enqueue("B");
        nodeQueueImplementation.enqueue("C");
        assertEquals("[A, B, C]", nodeQueueImplementation.toString());
    }

    @Test
    public void testToStringIsEmpty() {
        NodeQueueImplementation nodeQueueImplementation = new NodeQueueImplementation();
        assertEquals("[]", nodeQueueImplementation.toString());
    }
}
