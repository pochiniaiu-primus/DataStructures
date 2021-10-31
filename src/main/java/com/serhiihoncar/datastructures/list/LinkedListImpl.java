package com.serhiihoncar.datastructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedListImpl implements ListForLinkedList {
    private Node head;//ref to the next object
    private Node tail;//ref to the previews object
    int size = 0;

    private static class Node {
        private Object value;
        private Node next;

        public Node(Object element) {
            this.value = element;
            this.next = null;
        }
    }

    public LinkedListImpl() {
        this.head = this.tail = null;
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
    public void forEach(Consumer<? super Object> action) {
        ListForLinkedList.super.forEach(action);
    }

    @Override
    public Spliterator<Object> spliterator() {
        return ListForLinkedList.super.spliterator();
    }

    @Override
    public void addFirst(Object element) {
        Node firstNode = new Node(element);
        firstNode.next = head;
        head = firstNode;
        size++;
    }

    @Override
    public void addLast(Object element) {
        size++;
        if (head == null) {
            head = new Node(element);
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(element);
        }
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
            if (position == size) throw new NoSuchElementException();
            Node node = head;
            position++;
            for (int i = 1; i < position; i++) {
                node = node.next;
            }
            return node.value;
        }
    }
}