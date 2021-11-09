import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestArrayDequeGold {
    static StudentArrayDeque<Integer> stuA = new StudentArrayDeque<>();
    static ArrayDequeSolution<Integer> arrD = new ArrayDequeSolution<>();

    @Test
    public void testRandomRemove() {
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
        assertEquals(stuA.get(0), arrD.get(0));
        assertEquals(stuA.get(range - 2), arrD.get(range - 2));
    }






}
