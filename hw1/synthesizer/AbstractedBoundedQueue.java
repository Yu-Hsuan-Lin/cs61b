package synthesizer;

public abstract class AbstractedBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;
    public int fillCount() {
        return fillCount;
    }
    public int capacity() {
        return capacity;
    }


}
