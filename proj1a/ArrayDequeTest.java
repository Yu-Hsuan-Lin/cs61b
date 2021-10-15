public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        System.out.println(a.isEmpty());
        System.out.println(a.size());
        a.printDeque();
        // test addFirst
        a.addFirst(5);
        System.out.println(a.size());
        a.printDeque();
        a.addLast(6);
        System.out.println(a.size());
        a.printDeque();
        // System.out.println("nextfirst: " + a.nextFirst);
        a.addFirst(4);
        // System.out.println("nextfirst: " + a.nextFirst);
        System.out.println(a.size());
        a.printDeque();
        a.addFirst(3);
        a.addFirst(2);
        a.addFirst(1);
        a.addFirst(0);
        a.printDeque();
        // System.out.println("first: " + a.first + " nextFirst: " + a.nextFirst + " last: " + a.nextLast);
        System.out.println("----removeFirst------------");
        a.removeFirst();
        // System.out.println("first: " + a.first + " nextFirst: " + a.nextFirst + " last: " + a.nextLast);
       /* System.out.println(a.item.length);*/
        a.addLast(7);
        a.addLast(8);
        a.printDeque();
        // System.out.println("first: " + a.first + " nextFirst: " + a.nextFirst + " last: " + a.nextLast);
        a.addLast(9);
        a.printDeque();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.printDeque();

        ArrayDeque<Integer> a2 = new ArrayDeque<>();
        a2.addLast(0);
        a2.addFirst(1);
        a2.addLast(2);
        a2.addFirst(3);

        System.out.println(a2.removeLast());  // 4








    }
}
