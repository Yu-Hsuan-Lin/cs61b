/** After building SLList, DLList(circular sentinel --> make removeLast fast, prev, next),
 * we found that the efficiency of int get(i) is not constant, so we make a new data structure: AList.
 * Array is faster to find the Nth element since Array don't have to loop over,
 * Array mathmatically calculate the Nth element and get it, so whenever the element is, the efficiency is the same. */

// index   0  1   2  3  4  5
// item = {6, 9, -1, 0, 0, 0, 0...}
// size = 3
/** Invariants: (Things must be true. invariants is the mathy way to think about the program.)
 * addLast: the last item we want to add, will go into position size.
 * getLast: the item we want to return is in position size - 1.
 * size: the number of items in the list should be size.
 * */
/**
 * Performance problem:
 *      - the time growth of addLast for AList is parabola. 指數型成長O((1+N)*N/2) the time growth for SList is constant.
 *      - insert 1,000,000 and remove 990,000
 * Solution:
 * usage ratio = size/items.length
 * typical solution: half array size when R < 0.25
 * */

public class Alist<Item> {
    private Item[] items;
    private int size;
    public Alist() {
        items = (Item[]) new Object[100];  //items = new Item[100]  <- Generic Array Creation Error: type parameter can't be instantiated directly
        size = 0;
    }
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];  // Java don't allow to create array of generic type, so we create object and typecasting it into array
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addLast(Item x) {
        if (size >= items.length) {
            resize(size * 2);   //resize(size+RFACTOR) <-- unusably bad //resize(size*RFACTOR) <-- great performance
        }
        items[size] = x;
        size ++;
    }
    public Item getLast() {
        return items[size - 1];
    }
    public Item get(int i) {
        return items[i];
    }
    public int size() {
        return size;
    }
    public Item removeLast() {
        //items[size - 1] = 0; // yeah, won't hurt but unnecessary.
        Item last = getLast();
        items[size - 1] = null; // By nulling out items[2], Java is free to destroy the unneeded image from memory.
        size --;                   // we need to nulling unneeded items when using generic, otherwise we are loitering.  // think: why int is ok? because int int, all(0 or number) are the same memory(4 bytes) but objects of different kinds can take massive memory.
        return last;

        /*
        int returnItem = items[size -1];
        items[size -1] = 0;
        size --;
        return returnItem;
        * */
    }
}

