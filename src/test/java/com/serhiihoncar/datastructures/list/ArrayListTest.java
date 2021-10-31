package com.serhiihoncar.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    public void testAddShouldReturnSizeOfArrayList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        assertEquals(2, arrayList.size());
    }

    @Test
    public void testAddShouldThrowNullPointerExceptionWhenAddNull() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(NullPointerException.class, () -> {
            arrayList.add(null);
        });
        assertEquals(0, arrayList.size());
    }

    @Test
    public void testAddShouldThrowNullPointerExceptionWhenAddNullToIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        Assertions.assertThrows(NullPointerException.class, () -> {
            arrayList.add(null, 1);
        });
        assertEquals(2, arrayList.size());
    }

    @Test
    public void testSetShouldReturnRightResult() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.set("C", 0);
        assertEquals("[C, B, C]", arrayList.toString());
    }

    @Test
    public void testThrowNullPointerExceptionWhenSetNull() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        Assertions.assertThrows(NullPointerException.class, () -> {
            arrayList.set(null, 0);
        });
    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenWeUseBiggerThanOne() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("B", 2);
        });
    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenWeUseLessThanZero() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("B", -1);
        });
    }

    @Test
    public void testAddShouldReturnRightToStringArrayList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        assertEquals("[A, B]", arrayList.toString());
    }

    @Test
    public void testAddShouldReturnRightToStringArrayListOtherCase() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Hello");
        arrayList.add("world");
        assertEquals("[Hello, world]", arrayList.toString());
    }

    @Test
    public void testThrowNullPointerExceptionWhenArgumentIsNull() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(NullPointerException.class, () -> {
            arrayList.add(null);
        });
    }

    @Test
    public void testAddShouldReturnRightToStringArrayAfterAddElementToIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D", 1);
        assertEquals(4, arrayList.size());
        assertEquals("[A, D, B, C]", arrayList.toString());
    }

    @Test
    public void testRemoveShouldReturnRightToStringArrayAfterRemoveElementFromArrayList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.remove(2);
        assertEquals(2, arrayList.size());
        assertEquals("[A, B]", arrayList.toString());
    }

    @Test
    public void testThrowArrayIndexOutOfBoundsExceptionWhenRemoveElementWithNotExistIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            arrayList.remove(3);
        });
    }

    @Test
    public void testReturnTrueIfArrayGetReturnRightElement() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("D");
        assertEquals("D", arrayList.get(2));
        assertEquals(3, arrayList.size());
    }

    @Test
    public void testThrowArrayIndexOutOfBoundsExceptionWhenGetElementWithNotExistIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            arrayList.get(3);
        });
    }

    @Test
    public void testWorkWithAddSizeClearMethods() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        assertEquals(1, arrayList.size());
        arrayList.clear();
        assertTrue(arrayList.isEmpty());
        assertEquals(0, arrayList.size());
    }

    @Test
    public void testReturnIndexOfMethodLastIndexOf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        assertEquals(2, arrayList.lastIndexOf("C"));

    }

    @Test
    public void testRemove() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B", 1);
        arrayList.add("C", 1);
        arrayList.add("D", 1);
        arrayList.remove(2);
        assertEquals("[A, D, B]", arrayList.toString());

    }

    @Test
    public void testReturnZeroIndexOfMethodLastIndexOfWhenUseDontExistElement() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        assertEquals(0, arrayList.lastIndexOf("C"));

    }

    @Test
    public void testReturnLastIndexOfElementIndexOfMethod() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        assertEquals(1, arrayList.lastIndexOf("B"));

    }

    @Test
    public void testReturnIndexOfElementIndexOfMethod() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        assertEquals(1, arrayList.indexOf("B"));

    }

    @Test
    public void testReturnZeroIndexOfMethodIndexOfWhenUseDontExistElement() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        assertEquals(-1, arrayList.indexOf("C"));

    }

    @Test
    public void testContainsReturnTrueWhenArrayContainsElement() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("С");
        assertTrue(arrayList.contains("A"));
    }

    @Test
    public void testContainsReturnFalseWhenArrayDontContainsElement() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("С");
        assertFalse(arrayList.contains("D"));
    }

    @Test
    public void testGetWorkCorrect() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("С");
        assertEquals("B", arrayList.get(1));
    }

//    @Test
//    public void testSetWorkCorrect() {
//        ArrayList arrayList = new ArrayList();
//        arrayList.add("A");
//        arrayList.add("B");
//        arrayList.add("С");
//        arrayList.set("D", 2);
//        assertEquals("[A, B, D, C]", arrayList.toString());
//

    @Test
    public void testClearSizeIsEmptyWorkCorrect() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        assertEquals(3, arrayList.size());
        arrayList.clear();
        assertTrue(arrayList.isEmpty());
        assertEquals(0, arrayList.size());
    }
}