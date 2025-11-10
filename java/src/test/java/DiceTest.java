import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DiceTest {

    @Test
    public void tossWithinRange() {
        Dice d = new Dice(2);
        for (int i = 0; i < 1000; i++) {
            int sum = d.tossAndSum();
            assertTrue("sum out of range: " + sum, sum >= 2 && sum <= 12);
        }
    }

    @Test
    public void multipleRollsNotAllSame() {
        Dice d = new Dice(1);
        int first = d.tossAndSum();
        boolean different = false;
        for (int i = 0; i < 50; i++) {
            if (d.tossAndSum() != first) {
                different = true;
                break;
            }
        }
        assertTrue("multiple rolls unexpectedly identical", different);
    }

}
