package synthesizer;

import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    public Iterator<T> iterator() {
        return new BoundedIterator();
    }
    private class BoundedIterator implements Iterator<T> {
        private int wizPos;
        private int lastPos;
        private int halfPos;
        public BoundedIterator() {
            wizPos = first;
            lastPos = last;
        }
        public boolean hasNext() {
            if (first < last) {
                return wizPos < last;
            }
            return wizPos > first || wizPos < last;

        }
        public T next() {
            T returnItem = rb[wizPos];
            if (first <= last) {
                wizPos++;
            } else {
                if (wizPos == first) {
                    wizPos = 0;
                } else {
                    wizPos++;
                }
            }
            return returnItem;
        }
    }

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        first = capacity / 2;
        last = capacity / 2;
        fillCount = 0;
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // if the array is full
        if (fillCount >= capacity) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        int theEnd = capacity - 1;
        // if reach the end of the array
        rb[last] = x;
        fillCount++;
        last++;
        if (last > theEnd) {
            last = 0;
        }
    }

    /**
     * Dequeue the oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (fillCount == 0) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        int theEnd = capacity - 1;
        T returnVal = rb[first];
        rb[first] = null;
        fillCount--;
        first++;
        if (first > theEnd) {
            first = 0;
        }
        return returnVal;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (fillCount() == 0) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        return rb[first];
    }
}
