public class SLList<Blorp> implements List61B<Blorp> {
    /**
     * _____ SLList ----------
     * vs IntList:
     * - SLList more like java programming.
     * - Unlike IntList, SLList is an object, can store instance variable - size. Make size() more efficient.
     *
     * */
    /**
     * ____ Nested class ____________
     * Nested class: because IntNode is a feature of SLList. it is a subordinate class of boss class SLList.
     * Could have made IntNode a private nested class if we want.
     * Intance variables, constructors, and methods typically go below nested class definition.
     *
     * Why using nested class?
     * Nested classes are useful when the class doesn't stand on its own and is obviously subordinate to another class.
     * */
    // Make IntNode a private node because none outside the class need to manipulate IntNode
    // If the IntNode class never uses any details of the SLList class, add static.
    /**
     * ________ public ______________
     * public: a method is available and will work forever exactly as it does now.
     * */
    /**
     * ______________ static ________________
     * We can declare IntNode static, since it never use any of SLList's instance variables or methods.
     * Adv: save memory for each IntNode.
     * Nested static class: can not access outer class's stuff.
     * Unimportant note: For private nested class, access modifiers are irrelevant.
     * meaning that public int item is private(? since class IntNode is already private.
     * */
    private static class BlorpNode<Blorp> {
        public Blorp item;
        public BlorpNode next;

        public BlorpNode(Blorp item, BlorpNode next) {
            this.item = item;
            this.next = next;
        }
    }

    public void countPrint() {
        System.out.println(count);
    }

    /**
     * caching: This practice of saving important data to speed up retrieval.
     * the downside of size:
     *  1. have to store it every SSList(take up memory). 2. cause more time when running addFirst, addLast
     *  but the adv(save memory especially when size is very big) prevails disadv.
     * */
    public int size;
    /** ____--------_sentinel______________
     * The first item (if it exists) is at sentinel.next. */
    /** We use sentinel so that first(sentinel) won't be null. This is to prevent the special case in addLast().
     * If the sentinel node was a null node, would it change anything or would the Intlist be able to function?
     *      yes IntList can function, but IntList just becomes the same as the one without sentinel (start with first),
     *      that hold a null, causing special case in addFirst(). (my answer)
     * */
    private BlorpNode sentinel; //感覺不能寫成static, 因為每個instance都要有一個，不能共用。

    public SLList(Blorp x) {
        sentinel = new BlorpNode(null, null); //寫在這裡跟直接寫在上面是一樣的
        sentinel.next = new BlorpNode(x, null);
        size = 1;
    }

    /** Create empty list. */
    public SLList() {
        sentinel = new BlorpNode(null, null); // 63 can be any num.
        size = 0;
    }

    public SLList(Blorp[] blorpA) {
        sentinel = new BlorpNode(null, null);
        BlorpNode p = sentinel;
        for (int i = 0; i < blorpA.length; i ++) {
            size++;
            p.next = new BlorpNode(blorpA[i], null);
            p = p.next;
        }
    }

    /** Print out the SLList from sentinel to null. */
    public void iterative() {
        System.out.print(this.sentinel.item + " -> ");
        BlorpNode p = this.sentinel;
        while (p != null) {
            if (p.next == null) {
                System.out.print(p.next);
                return;
            }
            System.out.print(p.next.item + " -> ");
            p = p.next;
        }
        System.out.println();
        System.out.println();
    }

    /** Rebranding: IntList -> IntNode. We'll now build a new class SLList, which much more closely
     * resembles the list implementations that programmers use in modern languages. */
    /** Add x to the front of list. O(1) */
    public void addFirst(Blorp x) {
        size ++;
        // We don't use the following, because sentinel should always hold 63 for item.
//        sentinel = new IntNode(x, sentinel);
        sentinel.next = new BlorpNode(x, sentinel.next);

        /* addFirst method if SLList has an instance as first but not sentinel.
        * first.item = new IntNode(x, first.next);
        * No special case on AddFirst but has special case on AddLast.
        * */
    }

    /**
     * Compare to the addFirst method of IntList.
     * 因為SSList的 first 是IntNode本身所以可以直接first.item = x, 這樣去接。
     * 因為IntList的first 是int，而本身是this. this不能手動改變，所以要copy this to L, 再去調first, rest.
     * public void addFirst(int x) {
        IntList L = this;
        // 先複製this到Ｌ
        L = new IntList(this.first, this.rest);
        this.first = x;
        this.rest = L;
    }*/


    /** Bureaucracy: IntNode -> SLList.
     * Knowing that IntNodes are hard to work with, we're going to create a separate class called SLList
     * that the user will interact with. */
    /** Return the first item in the list. */
    public Blorp getFirst() {
        return (Blorp) sentinel.next.item;
    }

    public Blorp getLast() {
        return getLast(sentinel);
    }

    private Blorp getLast(BlorpNode p) {
        if (p.next == null) {
            return (Blorp) p.item;
        }
        return getLast(p.next);
    }

    public Blorp get(int i) {
        return get(sentinel.next, i);
    }

    private Blorp get(BlorpNode p, int i) {
        if (i == 0) {
            return (Blorp) p.item;
        }
        return get(p.next, --i);
    }

    /** Access control */
    /** Add x to the last of the list. */
    /** Two methods with the same name but different signatures are overloaded. */
    private void addLast(BlorpNode p, Blorp x) {
        /** If is empty list when using first but not sentinel, we got this special case.
         *  to prevent this special case, we change first into sentinel. */
        /*if (first == null) {
            first = new IntNode(x, null);
            return;
        }*/

        if (p.next == null) {
            p.next = new BlorpNode(x, null);
        } else {
            addLast(p.next, x);
        }
    }

    public void addLast(Blorp x) {
        addLast(sentinel, x);
        size ++;

    }
      /*  IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        // the last one
        p.next = new IntNode(x, null);*/

    /** We want to do size recursively, but we can't do things like first.next.size(),
     * because SLList is not a naked recursive data structure it can't call itself.
     * */
    /** Make it a naked recursive data structure. */
    /** Returns the size of the list that starts at IntNode p. */
    /** An alternate approach is to create a non-static helper method in the IntNode class itself.
     * Either approach is fine, though I personally prefer not having any methods in the IntNode class.*/
    private static int size(BlorpNode p) {
        if (p.next == null) {
            return 1;
        }
        return size(p.next) + 1;
    }
    /** return the size of the list. */
    public int size() {
        return size;
        // return size(first);

        /* while loop for size */
        /*int num = 1;
        IntNode p = first;
        while (p.next != null) {
            num ++;
            p = p.next;
        }
        return num;*/
    }
    /**  Deletes the first element in your SLLis. */
    public void deleteFirst() {
        sentinel.next = sentinel.next.next;
        size--;
    }
    /** Why we use DLList? Because we want removeLast() to have constant time and no if, else. */
    public Blorp removeLast(BlorpNode p) {
        size--;
        if (p.next == null) {
            return null;
        } else if (p.next.next == null) {
            BlorpNode temp = p.next;
            p.next = null;
            return (Blorp) temp.item;
        }
        return removeLast(p.next);

    }
    public Blorp removeLast() {
        return removeLast(sentinel);
    }

    public void insert(Blorp item, int position) {
        insert(sentinel, item, position);
    }
    private void insert(BlorpNode p, Blorp item, int position) {
        if (position == 0) {
            BlorpNode s = new BlorpNode (item, p.next);
            p.next = s;
        } else {
            insert(p.next, item, position-1);
        }
    }
    public void insertInter(Blorp item, int position) {
        BlorpNode p = sentinel.next;
        // if sentinel.next = null;
        if (sentinel.next == null || position == 0) {
            sentinel.next = new BlorpNode(item, p);
            return;
        }
        while (position != 1) {
            position --;
            p = p.next;
        }
        //if position = 1 is ok too
        p.next = new BlorpNode(item, p.next);
    }

    /* Reverse the existing list. destructive */
    public void reverse() {
        BlorpNode back = null;
        BlorpNode  recursHead = sentinel.next;
        while (recursHead != null) {
            BlorpNode nextHead = recursHead.next;
            recursHead.next = back;
            back = recursHead;
            recursHead = nextHead;
        }
        sentinel.next = back;
    }

    public void reverseRecursion() {
        reverseRecursion(sentinel.next);
    }
    private BlorpNode reverseRecursion(BlorpNode front) {
        if (front == null || front.next == null) {
            return front;
        } else {
            BlorpNode reversed = reverseRecursion(front.next);  // 6 // reversed = 6 > 5 > null  // 5
            front.next.next = front;  // front = 5. // 6 > 5  // 5 > 4
            front.next = null; // 6 > 5 > null  // 5 > 4 > null
            return reversed;  // 6 > 5 > null  // 5 > 4 > null
        }
    }

    @Override
    public void print() {
        System.out.println("The boss doesn't know what he is doing. ");
        for (BlorpNode p = sentinel.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }


    public void loopOver(BlorpNode p) {
        while (p != null) {
            if (p.next == null) {
                System.out.print(p.next);
                return;
            }
            System.out.print(p.next.item + " -> ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BlorpNode L1 = new BlorpNode(5, null);

        // In SLList, we don't have to specify address, which is hard for novices.
        // the SLList class acts as a middleman between the list user and the naked recursive data structure.
       /* SLList L2 = new SLList(15);
        L2.addFirst(10);
        L2.addFirst(5);
        System.out.println(L2.getFirst());
        L2.addLast(50);
        System.out.println(L2.size());
        System.out.println("before deleteFirst: " + L2.getFirst());
        L2.deleteFirst();
        System.out.println("deleteFirst: " + L2.getFirst());

        SLList L3 = new SLList();
        L3.addLast(10);
        System.out.println(L3.getFirst());


        System.out.println("=====================");
        // Compare to IntList
        // Naked recursion
        BlorpNode L = new BlorpNode(15, null);
        L = new BlorpNode(10, L);
        L = new BlorpNode(5, L);
*/
        System.out.println("======= array try ===========");
        SLList<Integer> list = new SLList<>();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.insert(100, 3);
        list.print();

        List61B<Integer> list2 = new SLList<>();
        list2.addFirst(5);
        list2.addFirst(4);
        list2.addFirst(3);
        list2.addFirst(2);
        list2.addFirst(1);
        list2.insert(100, 3);
        list2.removeLast();
        list2.removeLast();
        list2.print();
        SLList<Integer> list3 = new SLList<>();
        list3.countPrint();





    }
}
