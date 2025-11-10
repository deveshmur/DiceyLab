import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SimulationTest {

    @Test
    public void runSimulationTotalsMatch() {
        int tosses = 1000;
        Simulation sim = new Simulation(2, tosses);


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        try {
            sim.runSimulation();
            sim.printResults();
        } finally {
            System.setOut(old);
        }

        String output = baos.toString();


        Pattern p = Pattern.compile("\\s*\\d+\\s*:\\s*(\\d+):");
        Matcher m = p.matcher(output);
        int total = 0;
        int matches = 0;
        while (m.find()) {
            matches++;
            total += Integer.parseInt(m.group(1));
        }

        assertTrue("no histogram lines found", matches > 0);
        assertEquals("total tosses should equal the sum of bins", tosses, total);
    }

}
