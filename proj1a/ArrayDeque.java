/** The difference between ArrayDeque and AList? */
public class ArrayDeque<T> {
    private T[] item;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int first;
    private int last;
    private int mid;
    public ArrayDeque() {
        item = (T[]) new Object[8];
        size = 0;
        mid = (int) (item.length / 2);
        nextFirst = (int) (item.length / 2);
        nextLast = nextFirst + 1;
    }
     // adjust starting point
    private void resize(int capacity) {
        T[] newI = (T[]) new Object[capacity];
        int start = 0;
         // If capacity > size
        if (capacity > item.length) {
            start = (int) (capacity / 2 - size / 2);
            if (first > mid) {
                 // from first to item.length - 1
                System.arraycopy(item, first, newI, start, item.length - 1 - first);
                System.arraycopy(item, 0, newI, item.length - 1 - first + 1, last + 1);
            } else if (last < mid) {
                System.arraycopy(item, first, newI, start, item.length - 1 - first);
                System.arraycopy(item, 0, newI, item.length - 1 - first, last + 1);
            } else {
                 // from 0 to item.length - 1
                System.arraycopy(item, 0, newI, start, size);
            }
            first = start;
            nextFirst = first - 1;
            last = start + size - 1;
            nextLast = last + 1;

        } else {
             // If capacity < size
            start = (int) (capacity / 2 - size/2);
            System.arraycopy(item, first, newI, start, size);
            first = start;
            nextFirst = first - 1;
            last = start + size - 1;
            nextLast = last + 1;
        }

        item = newI;
        mid = item.length / 2;
    }

    /** Add and remove must take constant time. */
    public void addFirst(T x) {
        if (size >= item.length) {
            resize(size * 2);
        }
        if (nextFirst < 0) {
            nextFirst = item.length - 1;
        }
        item[nextFirst] = x;
        first = nextFirst;
        if (size == 0) {
            last = first;
        }
        nextFirst--;   // -1
        size++;
    }
    public void addLast(T x) {
        if (size >= item.length) {
            resize(size * 2);
        }
        if (nextLast > item.length - 1) {
            nextLast = 0;
        }
        item[nextLast] = x;
        last = nextLast;
        if (size == 0) {
            first = last;
        }
        nextLast++;
        size++;
    }
    public boolean isEmpty() {
        return item[first] == null;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
         // System.out.println(item.length);
 //        System.out.println("print: " + "first: " + first + " last: " + last + " mid: " + mid);
         // If first starts from back. (In this case, last should always > mid)
        if ((first > mid && item[0] != null) || (last < mid && item[item.length - 1] != null)) {
            for (int i = first; i < item.length; i ++) {
                System.out.print(item[i] + " ");
            }
            for (int i = 0; i <= last; i ++) {
                System.out.print(item[i] + " ");
            }

        } else {
            for (int i = first; i <= last; i ++) {
                System.out.print(item[i] + " ");
            }
        }
        System.out.println();
    }
    /** Add and remove must take constant time. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        double now = (double) size / item.length;
        if (now < 0.25 ) {
            resize(item.length / 2);
        }
        T hold = item[first];
        item[first] = null;
        nextFirst = first;
        if (first == item.length - 1) {
            first = 0;
        } else {
            first++;
        }
        size--;
        return hold;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (size / item.length < 0.25 ) {
            resize(item.length / 2);
        }
        T hold = item[last];
        item[last] = null;
        nextLast = last;
        if (last == 0) {
            last = item.length - 1;
        } else {
            last--;
        }
        size--;
        return hold;
    }
    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null.*/
    public T get(int index) {
        int getIndex = (int) (item.length / 2) + index;
        if (getIndex >= item.length) {
            getIndex -= item.length;
        }
        return item[getIndex];
    }


}
