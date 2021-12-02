package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
    ArrayRingBuffer<Integer> arb2 = new ArrayRingBuffer<>(7);
    @Test
    public void testStartSetting() {
        assertEquals(10, arb.capacity());
        assertEquals(0,arb.fillCount());
    }
    @Test
    public void testSome() {
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);
        arb.enqueue(6);
        arb.enqueue(7);
        arb.enqueue(8);
        arb.enqueue(9);
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        // Integer[] expected = new Integer[]{8, 9, null, null, null, null, null, null, null, 7};
        assertEquals(7, (int) arb.peek());
    }
    @Test
    public void testCornerCase() {
        for (int i = 0; i < 6; i++) {
            arb2.enqueue(i);
        }
        for (int i = 0; i < 5; i++) {
            arb2.dequeue();
        }
        for (int i = 6; i < 9; i++) {
            arb2.enqueue(i);
        }
        // Integer[] expected = new Integer[]{null, 5, 6, 7, 8, null, null};
        // assertArrayEquals(expected, arb2.getRb());
        assertEquals(5, (int) arb2.peek());

    }
    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
        ArrayRingBuffer<Integer> a = new ArrayRingBuffer<>(7);
        // TestException
        // a.dequeue();
       /* For (int i = 0; i < 6; i++) {
            a.enqueue(i);
        }
        a.enqueue(7);*/

        /*for (int i = 0; i < 6; i++) {
            a.enqueue(i);
        }
        for (int i = 0; i < 5; i++) {
            a.dequeue();
        }
        for (int i = 6; i < 9; i++) {
            a.enqueue(i);
        }
        Iterator<Integer> ai = a.iterator();
        while(ai.hasNext()) {
            int i = ai.next();
            System.out.println(i);
        }*/
        a.enqueue(3);
        a.enqueue(4);
        a.enqueue(5);
        a.enqueue(6);
        a.enqueue(7);
        a.enqueue(8);
        a.enqueue(9);
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        for (Object i : a) {
            if (i != null) {
                System.out.println((int)i);
            }
        }



    }
}
