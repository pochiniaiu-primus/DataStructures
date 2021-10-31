package com.serhiihoncar.datastructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedListImpl implements ListForLinkedList {
    private Node head;//ref to the head
    private Node tail;//ref to the tail
    int size = 0;

    private static class Node {
        private Object value;
        private Node next;//ref to the next element

        public Node(Object element) {
            this.value = element;
            this.next = null;
        }
    }

    public LinkedListImpl() {
        this.head = this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        while (head.next != null) {
            head = head.next;
        }
        head.value = null;
        tail.value = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void forEach(Consumer<? super Object> action) {
        ListForLinkedList.super.forEach(action);
    }

    @Override
    public Spliterator<Object> spliterator() {
        return ListForLinkedList.super.spliterator();
    }

    @Override
    public void addFirst(Object element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(Object element) {
//        size++;
//        if (head == null) {
//            head = new Node(element);
//        } else {
//            Node node = head;
//            while (node.next != null) {
//                node = node.next;
//            }
//            node.next = new Node(element);
//        }
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void removeFirst() {
        if (this.head != null) {
            head.value = null;
            head = head.next;
            size--;
        }
    }

    @Override
    public void removeLast() {
        if (head != null) {
            Node current = head;
            if (current.next == null) {
                clear();
                return;
            }
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
            size--;
        }
    }

    public int get(Object o) {
        if (isEmpty()) {
            return -1;
        }
        if (head.value == o) {
            return 0;//the element that we looking at is first
        }
        Node currentNode = head;
        int result = 0;
        while (currentNode.next != null) {
            ++result;
            if (currentNode.next.value == o) {
                return result;
            }
            currentNode=currentNode.next;
        }
        return -1;
    }

    @Override
    public Object getFirst() {
        return head.value;
    }

    @Override
    public Object getLast() {
        if (head != null) {
            Node current = head;
            if (current.next == null) {
                return head.value;
            }
            while (current.next.next != null) {
                current = current.next;
            }
            return current.next.value;
        }
        return null;
    }

    @Override
    public Object search(Object element) {
        if (head == null) {
            return null;
        }
        if (head.value == element) {
            return head.value;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            if (head.value == element) {
                return currentNode.value;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        if (head == null) {
            return false;
        }
        if (head.value == element) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.value == element) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
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
            if (position == size)
                throw new NoSuchElementException();
            Node node = head;
            position++;
            for (int i = 1; i < position; i++) {
                node = node.next;
            }
            return node.value;
        }
    }
}