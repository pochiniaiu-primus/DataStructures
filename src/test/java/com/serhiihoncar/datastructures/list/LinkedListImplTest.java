package com.serhiihoncar.datastructures.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListImplTest {

    @Test
    public void testAddFirstShouldReturnSizeOfLinkedList() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        assertEquals(2, linkedList.size());
    }

    @Test
    public void testGetFirstShouldReturnRightFirstElement() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.addFirst("C");
        assertEquals("C", linkedList.getFirst());
    }

    @Test
    public void testAddLastAndGetLastShouldReturnRightLastElement() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.addLast("C");
        assertEquals("C", linkedList.getLast());
    }

    @Test
    public void testClearShouldClearLinkedList() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.addLast("C");
        linkedList.clear();
        assertEquals(0, linkedList.size);
    }

    @Test
    public void testSizeShouldReturnRightSizeOfLinkedList() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.addLast("C");
        assertEquals(3, linkedList.size);
    }

    @Test
    public void testRemoveLastShouldReturnRightLinkedList() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.addLast("C");
        linkedList.removeLast();
        assertEquals("[B, A]", linkedList.toString());
    }

    @Test
    public void testGetFirstShouldReturnRightElement() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.getFirst();
        assertEquals("[B, A]", linkedList.toString());
    }

    //    @Test
//    public void testSearchShouldReturnRightBoolean() {
//        LinkedListImpl linkedList = new LinkedListImpl();
//        linkedList.addFirst("A");
//        linkedList.addFirst("B");
//        assertEquals(true, linkedList.search("B"));
//    }
    @Test
    public void testRemoveElementShouldReturnRightLinkedList() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.remove("A");
        assertEquals("[B]", linkedList.toString());
    }
}