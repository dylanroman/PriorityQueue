//
// Name: Roman, Dylan
// Project #4
// 11/4/2025
// Course: cs-2400-03-f25
//
// Description:
// Uses a Max Heap to implement a Priority Queue. Priority queue is tested in an ER room simulator.
//

/** Priority Queue stores data and dequeues data based on priority. If two elements have the same priority, the element that was enqueued first is dequeued first. */
public interface PriorityQueueInterface<T extends Comparable<? super T>> {
    /** Adds a new entry into the priority queue.
     * @param newEntry Data to be added to priority queue. */
    public void add(T newEntry);

    /** Retrieves and returns the first entry with the highest priority.
     * @return Data that is first and has the highest priority */
    public T remove();

    /** Retrieves the first entry with the highest priority.
     * @return Data that is first and has the highest priority */
    public T peek();

    /** Checks whether the priority queue is empty.
     * @return True if the priority queue has no elements, false if the priority queue has elements. */
    public boolean isEmpty();

    /** Gets the current size of the priority queue.
     * @return The number of entries currently in the priority queue. */
    public int getSize();

    /** Removes all entries from the priority queue. */
    public void clear();
}

