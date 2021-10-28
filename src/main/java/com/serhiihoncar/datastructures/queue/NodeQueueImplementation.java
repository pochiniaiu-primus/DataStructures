package com.serhiihoncar.datastructures.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * // Appends the specified element to the end.
 * void enqueue(Object element);
 * <p>
 * // Removes the head.
 * Object dequeue();
 * <p>
 * // Returns the head.
 * Object top();
 * <p>
 * // Removes all of the elements.
 * void clear();
 * <p>
 * // Returns the number of elements.
 * int size();
 * <p>
 * // Returns a string representation of this container.
 * String toString();
 * <p>
 * // Returns an iterator over elements.
 * // Iterator must implements the remove method.
 * Iterator<Object> iterator();
 */

public class NodeQueueImplementation implements NodeQueue {
    private Node head;
    private Node tail;
    private int size = 0;

    private static class Node {
        private Object value;
        private Node next;

        public Node(Object element) {
            this.value = element;
        }
    }

    @Override
    public void clear() {
        while (head.next != null) {
            head = head.next;
        }
        head.value = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        private int position = 0;

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public Object next() {
            if (position == size) throw new NoSuchElementException();
            Node node = head;
            position++;
            for (int i = 1; i < position; i++) {
                node = node.next;
            }
            return node.value;
        }
    }

    @Override
    public void enqueue(Object element) {
        Node node = new Node(element);
        if (head == null) {
            head = node;
        }
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        size++;
    }


    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        } else if (head == tail) {
            Object o = head.value;
            head = null;
            tail = null;
            size--;
            return o;
        }

        Object o = head.value;
        head = head.next;
        size--;
        return o;

    }

//    @Override
//    public Object dequeue() {
//        if(isEmpty()){
//            throw new NoSuchElementException();
//        }
//        head = head.next;
//        if (head == null) {
//            tail = null;
//            size = 0;
//        }
//        size--;
//        return head.value;
//    }

//    @Override
//    public Object dequeue() {
//        head = head.next;
//        if (head == null) {
//            tail = null;
//            size--;
//        }
//        return head.value;
//    }


    @Override
    public Object top() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }
        return head.value;
    }

    protected boolean isEmpty() {// return head == null;
        return size == 0;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        Node temp = head;
        while (temp != null) {
            if (temp.value == null) {
                result.append("null");
            } else {
                result.append(temp.value);
            }

            if (temp.next == null) {
                result.append("]");
            } else {
                result.append(", ");
            }
            temp = temp.next;
        }
        return result.toString();
    }


    public static void main(String[] args) {
        NodeQueue nodeQueue = new NodeQueueImplementation();
        nodeQueue.enqueue(1);
        nodeQueue.enqueue(2);
        nodeQueue.enqueue(3);
        nodeQueue.enqueue(4);

        for (Object el : nodeQueue) {
            System.out.println(el);
        }
    }
}
