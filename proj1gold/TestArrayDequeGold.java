import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestArrayDequeGold {
    static StudentArrayDeque<Integer> stuA = new StudentArrayDeque<>();
    static ArrayDequeSolution<Integer> arrD = new ArrayDequeSolution<>();

    @Test
    public void testWithMsg() {
        StudentArrayDeque stu = new StudentArrayDeque<Integer>();
        ArrayDequeSolution sol = new ArrayDequeSolution<Integer>();

        for (int i = 0; i <= 10; i++) {
            int last = StdRandom.uniform(11, 20);

            stu.addLast(last);
            sol.addLast(last);

        }

        String msg = helper1(sol);
        for (int i = 0; i <= 10; i++) {

            Object expected = sol.removeLast();
            Object actual = stu.removeLast();

            assertEquals(helper(i, msg), expected, actual);
        }


    }

    private String helper1(ArrayDequeSolution<Integer> ads) {
        String newMsg;
        String res = "Oh noooo!\n   This is bad:\n   Related Operation:\n";

        for(int i = 0; i<10; i++) {
            newMsg = "   addLast(" + ads.get(i) + ");\n";
            res += newMsg;
        }

        return res;
    }

    private String helper(int len, String msg) {

        for (int i = 0; i<len; i++) {
            msg += "   removeLast();\n";
        }
        return msg;
    }

    /*@Test
    public void testRandomRemoveLast() {
        int range = StdRandom.uniform(10);
        for (int i = 0; i < range; i++) {
            double check = StdRandom.uniform();
            if (check < 0.5) {
                stuA.addLast(i);
                arrD.addLast(i);
            } else {
                stuA.addFirst(i);
                arrD.addFirst(i);
            }
        }
        for (int i = 0; i < range; i++) {
            stuA.
        }
        assertEquals(stuA.removeLast(), arrD.removeLast());
    }*/

    /*@Test
    public void testRandomRemoveFirst() {
        int range = StdRandom.uniform(10);
        for (int i = 0; i < range; i++) {
            double check = StdRandom.uniform();
            if (check < 0.5) {
                stuA.addLast(i);
                arrD.addLast(i);
            } else {
                stuA.addFirst(i);
                arrD.addFirst(i);
            }
        }
        assertEquals(stuA.removeFirst(), arrD.removeFirst());
    }*/






}
