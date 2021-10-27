package com.serhiihoncar.datastructures.queue;

//FIFO
public interface Queue {
    //add() -> adding element
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

//    Object remove(); // delete element
//    Object poll();  // get element end delete this element queue
//    boolean offer(Object o);

}