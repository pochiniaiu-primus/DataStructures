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

    @Test
    public void testSearchShouldReturnRightElementIfItExistInLinkedList() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        assertEquals("B", linkedList.search("B"));
    }

    @Test
    public void testSearchShouldReturnNullIfElementDontExistInElement() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        assertEquals(null, linkedList.search("C"));
    }

    @Test
    public void testRemoveElementShouldReturnRightLinkedList() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.remove("A");
        assertEquals("[B]", linkedList.toString());
    }

    @Test
    public void testRemoveElementShouldReturnFalseIfHeadDontHaveAnyValue() {
        LinkedListImpl linkedList = new LinkedListImpl();
        assertEquals(false, linkedList.remove("A"));
    }
    @Test
    public void testRemoveHeadValueElementShouldReturnTrueIfHeadHaveElement() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        assertEquals(true, linkedList.remove("A"));
    }

    @Test
    public void testRemoveFirstElementShouldReturnRightLinkedList() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.addFirst("C");
        linkedList.removeFirst();
        assertEquals("[B, A]", linkedList.toString());
    }

    @Test
    public void testIsEmptyShouldReturnTrueIfLinkedListEmpty() {
        LinkedListImpl linkedList = new LinkedListImpl();
        assertEquals(true, linkedList.isEmpty());
    }

//    @Test
//    public void testGetShouldReturnZeroIfElementExistInLinkedList() {
//        LinkedListImpl linkedList = new LinkedListImpl();
//        assertEquals(0, linkedList.get("A"));
//    }

    @Test
    public void testToStringShouldReturnEmptyTLinkedListEmpty() {
        LinkedListImpl linkedList = new LinkedListImpl();
        assertEquals("[]", linkedList.toString());
    }
}