public class LinkedListDeque<T> {
    private class TNode {
        private TNode prev;
        private T item;
        private TNode next;

        private TNode(TNode prev, T item, TNode next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    private TNode sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    /* public LinkedListDeque(T x) {
        sentinel = new TNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = new TNode (this.sentinel, x, this.sentinel);
        size++;
    }*/
    public void addFirst(T item) {
        sentinel.next = new TNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;

        size++;
    }
    public void addLast(T item) {
        sentinel.prev = new TNode(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }
    public boolean isEmpty() {
        return sentinel.next.item == null;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        TNode p = sentinel.next;
        while (p.item != null) {
            if (p.next == null) {
                System.out.print(p.item);
            } else {
                System.out.print(p.item + " ");
            }
            p = p.next;
        }
        System.out.println();
    }
    /** Removes and returns the item. If no such item exists, returns null.*/
    public T removeFirst() {
        if (size == 0) {   // empty linkedList
            return null;
        }
        size--;
        T hold = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel.next;

        return hold;
    }
    public T removeLast() {    // empty linkedList
        if (size == 0) {
            return null;
        }
        size--;
        T hold = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return hold;
    }
    public T get(int index) {
        TNode p = sentinel.next;
        // if no such item exist, return null;
        if (index >= size) {
            return null;
        }
        for (int i = 1; i < index + 1; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel);
    }
    private T getRecursive(int index, TNode p) {
        if (index == -1 || index >= size || index < -1) {
            return p.item;
        }
        return getRecursive(index - 1, p.next);
    }
}
