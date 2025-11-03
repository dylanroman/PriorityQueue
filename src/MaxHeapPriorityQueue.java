public class MaxHeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {

    private MaxHeapInterface<T> priorityQueue;
    int capacity;

    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public MaxHeapPriorityQueue(int capacity) {
        checkCapacity(capacity);

        priorityQueue = new MaxHeap<>(capacity);
        this.capacity = capacity;
    }

    public MaxHeapPriorityQueue() {
        this(DEFAULT_CAPACITY);
    }

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalArgumentException("Attempt to create priority queue whose max capacity exceeds maximum capacity of " + MAX_CAPACITY);
        }
    }

    public void displayPriorityQueue() {
        System.out.println(priorityQueue.toString());
    }

    @Override
    public void add(T newEntry) {
        priorityQueue.add(newEntry);
    }

    @Override
    public T remove() {
        return priorityQueue.removeMax();
    }

    @Override
    public T peek() {
        return priorityQueue.getMax();
    }

    @Override
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    @Override
    public int getSize() {
        return priorityQueue.getSize();
    }

    @Override
    public void clear() {
        priorityQueue.clear();
    }
}
