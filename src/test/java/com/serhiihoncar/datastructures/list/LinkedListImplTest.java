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
    public void testAddToIndexZeroShouldReturnRightLinkedList() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        linkedList.addLast("B");
        linkedList.add("C", 0);
        assertEquals("[C, A, B]", linkedList.toString());
    }

    @Test
    public void testAddToNullShouldReturnRightLinkedList() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        linkedList.addLast("B");
        linkedList.addLast("null");
        assertEquals("[A, B, null]", linkedList.toString());
    }

    @Test
    public void testAddToLastIndexShouldReturnRightLinkedList() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        linkedList.addLast("B");
        linkedList.addLast("C");
        linkedList.addLast("D");
        linkedList.add("E", 3);
        assertEquals("[A, B, C, D, E]", linkedList.toString());
    }

    @Test
    public void testAddIsSizeZeroShouldReturnRightLinkedList() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.add("A", 0);
        assertEquals("[A]", linkedList.toString());
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
    public void testAddLastIfLinkedListIsEmptyShouldReturnRightLinkedList() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addLast("A");
        assertEquals("[A]", linkedList.toString());
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

    @Test
    public void testSearchShouldReturnNullIfElementInLinkedListDontExist() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.addFirst("C");
        assertEquals(null, linkedList.search("D"));
    }

    @Test
    public void testGetLastShouldReturnNullIfElementInLinkedListDontExist() {
        LinkedListImpl linkedList = new LinkedListImpl();
        assertEquals(null, linkedList.getLast());
    }

    @Test
    public void testSearchShouldReturnNullIfHeadIsNull() {
        LinkedListImpl linkedList = new LinkedListImpl();
        assertEquals(null, linkedList.search("D"));
    }

    @Test
    public void testRemoveShouldReturnFalseIfElementDontExistInLinkedList() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.addFirst("C");
        assertEquals(false, linkedList.remove("D"));
    }

    //the element that we looking at is first
    @Test
    public void testGetShouldReturnMinusOneIfElementExistInLinkedList() {
        LinkedListImpl linkedList = new LinkedListImpl();
        assertEquals(-1, linkedList.get("A"));
    }

    @Test
    public void testGetShouldReturnZeroIfElementHeadOfLinkedList() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        assertEquals(0, linkedList.get("A"));
    }

    @Test
    public void testGetShouldReturnMinusOneIfElementDontExistInLinkedList() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("A");
        assertEquals(-1, linkedList.get("B"));
    }

    @Test
    public void testToStringShouldReturnEmptyTLinkedListEmpty() {
        LinkedListImpl linkedList = new LinkedListImpl();
        assertEquals("[]", linkedList.toString());
    }
}