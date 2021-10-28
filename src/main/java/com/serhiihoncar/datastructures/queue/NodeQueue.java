package com.serhiihoncar.datastructures.queue;

import com.serhiihoncar.datastructures.container.Container;

public interface NodeQueue extends Container {
    // Appends the specified element to the end.
    void enqueue(Object element);

    // Removes the head.
    Object dequeue();

    // Returns the head.
    Object top();
}
