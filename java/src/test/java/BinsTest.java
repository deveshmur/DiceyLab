import org.junit.Test;

import static org.junit.Assert.*;

public class BinsTest {

    @Test
    public void incrementAndGet() {
        Bins b = new Bins(2, 12);
        assertEquals(0, b.getBin(7));
        b.incrementBin(7);
        assertEquals(1, b.getBin(7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void incrementOutOfRangeThrows() {
        Bins b = new Bins(2, 12);
        b.incrementBin(1);
    }

    @Test
    public void getOutOfRangeReturnsZero() {
        Bins b = new Bins(2, 12);
        assertEquals(0, b.getBin(1));
    }

}
