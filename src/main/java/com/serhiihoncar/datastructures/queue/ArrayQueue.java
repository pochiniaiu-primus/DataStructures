package com.serhiihoncar.datastructures.queue;

/**
 void enqueue(Object value);

 //element()
 Object dequeue();

 int size();

 boolean isEmpty();

 boolean contains(Object value);

 void clear();

 //size don't change, get element and don't delete this element from queue
 Object peek();

 //[A, B, C] if size=3
 String toString();
 */
//FIFO
public class ArrayQueue implements Queue {
    private int size;
    private Object[] array;

    public ArrayQueue() {
        array = new Object[10];
    }
    public ArrayQueue(int initialCapacity) {
        array = new Object[initialCapacity];
    }

    @Override
    public void enqueue(Object value) {
        ensureCapacity();
        array[size] = value;
        size++;
    }

    private void ensureCapacity() {
        if (array.length == size) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        Object result = array[0];
        for (int i = 0; i < size; i++) {//size-1
            array[i] = array[i + 1];
        }
        size--;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            Object valueInQueue = array[i];
            if (value.equals(valueInQueue)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        Object result = array[0];
        return result;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilderResult = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilderResult.append(array[i]);
            if (i < size - 1 ) {
                stringBuilderResult.append(", ");
            }
        }
        return "[" + stringBuilderResult + "]";
    }
}
