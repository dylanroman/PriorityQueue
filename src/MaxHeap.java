//
// Name: Roman, Dylan
// Project #4
// 11/4/2025
// Course: cs-2400-03-f25
//
// Description:
// Uses a Max Heap to implement a Priority Queue. Priority queue is tested in an ER room simulator.
//

public class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T>{

    private T[] heap;
    private int lastIndex;
    private int capacity;

    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    public MaxHeap(int capacity) {
        checkCapacity(capacity + 1);

        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[capacity + 1];
        heap = temp;
        lastIndex = 0;
        this.capacity = capacity;

        integrityOK = true;
    }

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalArgumentException("Attempt to create heap whose max capacity exceeds maximum capacity of " + MAX_CAPACITY);
        }
    }

    private void checkIntegrity() {
        if (!integrityOK) {
            throw new SecurityException("Heap is corrupt");
        }
    }

    private T getLeftChild(int parent) {
        return heap[2 * parent];
    }

    private T getRightChild(int parent) {
        return heap[2 * parent + 1];
    }

    private T getParent(int child) {
        return heap[child / 2];
    }

    private void resizeHeap() {
        checkCapacity(capacity * 2);
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[capacity * 2];

        for (int i = 0; i <= lastIndex; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
        capacity = capacity * 2;
    }

    private int reHeap(int index) {
        if (index == 1 || heap[index].compareTo(getParent(index)) <= 0) {
            return index;
        }

        T temp = heap[index];
        heap[index] = getParent(index);
        heap[index / 2] = temp;

        return reHeap(index / 2);
    }

    private int reverseReHeap(int index) {
        if (getLeftChild(index) == null && getRightChild(index) == null) {
            return index;
        }

        int comparisonIndex;

        if (getRightChild(index) == null) {
            comparisonIndex = index * 2;
        } else {
            if (getLeftChild(index).compareTo(getRightChild(index)) <= 0) {
                comparisonIndex = index * 2 + 1;
            } else {
                comparisonIndex = index * 2;
            }
        }

        if (heap[index].compareTo(heap[comparisonIndex]) >= 0) {
            return index;
        } else {
            T temp = heap[index];
            heap[index] = heap[comparisonIndex];
            heap[comparisonIndex] = temp;
            return reverseReHeap(comparisonIndex);
        }
    }

    public void displayHeap() {
        if (!isEmpty()) {
            System.out.print("[ ");
            for (int i = 1; i < lastIndex; i++) {
                System.out.print(heap[i] + ", ");
            }

            System.out.println(heap[lastIndex] + " ]");
        } else {
            System.out.println("[ ]");
        }
    }

    @Override
    public void add(T newEntry) {
        checkIntegrity();
        checkCapacity(lastIndex++);

        if (lastIndex == capacity) {
            resizeHeap();
        }

        heap[lastIndex] = newEntry;
        reHeap(lastIndex);
    }

    @Override
    public T removeMax() {
        T temp = heap[1];
        heap[1] = heap[lastIndex];
        heap[lastIndex--] = null;
        reverseReHeap(1);

        return temp;
    }

    @Override
    public T getMax() {
        return heap[lastIndex];
    }

    @Override
    public boolean isEmpty() {
        return lastIndex == 0;
    }

    @Override
    public int getSize() {
        return lastIndex;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            removeMax();
        }
    }
}
