//
// Name: Roman, Dylan
// Project #4
// 11/4/2025
// Course: cs-2400-03-f25
//
// Description:
// Uses a Max Heap to implement a Priority Queue. Priority queue is tested in an ER room simulator.
//

/** Max Heap is a complete binary tree where parent nodes are greater than or equal to the values of its children. */
public interface MaxHeapInterface<T extends Comparable<? super T>> {
    /** Adds an entry into the heap. Ensures parent nodes are greater than or equal to children nodes.
     * @param newEntry Entry to be added into the heap. */
    public void add(T newEntry);

    /** Removes and returns the top element from the heap.
     * @return Largest element in the heap. */
    public T removeMax();

    /** Gets the top value of the heap.
     * @return Largest element in the heap. */
    public T getMax();

    /** Checks if heap is empty.
     * @return True if the heap contains no elements. False if heap contains at least 1 element. */
    public boolean isEmpty();

    /** Gets the number of elements in the heap.
     * @return The size of the heap. */
    public int getSize();

    /** Removes all elements in the heap. */
    public void clear();
}
