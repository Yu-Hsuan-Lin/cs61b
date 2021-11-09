import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestArrayDequeGold {
    static StudentArrayDeque<Integer> stuA = new StudentArrayDeque<>();
    static ArrayDequeSolution<Integer> arrD = new ArrayDequeSolution<>();


    @Test
    public void testRandomRemoveLast() {
        int range = StdRandom.uniform(10);
        Integer ansLast = null;
        Integer ansFirst = null;
        for (int i = 0; i < range; i++) {
            if (i == 0) {
                ansLast = i;
                ansFirst = i;
            }
            double check = StdRandom.uniform();
            if (check < 0.5) {
                stuA.addLast(i);
                arrD.addLast(i);
                ansLast = i;
                // System.out.println("addLast: " + i);
            } else {
                stuA.addFirst(i);
                arrD.addFirst(i);
                ansFirst = i;
                // System.out.println("addFirst: " + i);
            }
        }
        stuA.printDeque();
        // System.out.println("last: " + stuA.removeLast());
        // System.out.println("first: " + stuA.removeFirst());
        assertEquals("removeLast() is wrong.", arrD.removeLast(), stuA.removeLast());
        assertEquals("removeFirst() is wrong.", arrD.removeFirst(), stuA.removeFirst());
        // System.out.println(arrD.removeFirst());

    }







}
