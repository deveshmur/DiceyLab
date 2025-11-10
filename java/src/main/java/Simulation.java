
public class Simulation {
	private final int numberOfDice;
	private final int numberOfTosses;
	private final Dice dice;
	private final Bins bins;

	public Simulation(int numberOfDice, int numberOfTosses) {
		if (numberOfDice < 1) {
			throw new IllegalArgumentException("numberOfDice must be >= 1");
		}
		if (numberOfTosses < 1) {
			throw new IllegalArgumentException("numberOfTosses must be >= 1");
		}
		this.numberOfDice = numberOfDice;
		this.numberOfTosses = numberOfTosses;
		this.dice = new Dice(numberOfDice);
		int min = numberOfDice;
		int max = numberOfDice * 6;
		this.bins = new Bins(min, max);
	}

	public void runSimulation() {
		for (int i = 0; i < numberOfTosses; i++) {
			int sum = dice.tossAndSum();
			bins.incrementBin(sum);
		}
	}



	public void printResults() {
		System.out.println();
		System.out.println("***");
		System.out.println("Simulation of " + numberOfDice + " dice tossed for " + numberOfTosses + " times.");
		System.out.println("***");
		System.out.println();

		
		int maxCount = 0;

		for (int v = bins.getMin(); v <= bins.getMax(); v++) {
			int count = bins.getBin(v);
			if (count > maxCount) {
				maxCount = count;
			}
		}

		for (int value = bins.getMin(); value <= bins.getMax(); value++) {
			int count = bins.getBin(value);
			double fraction = count / (double) numberOfTosses;
			int stars = (int) Math.round((count / (double) maxCount) * 100);

			StringBuilder bar = new StringBuilder();
			for (int s = 0; s < stars; s++) {
				bar.append('*');
			}

			System.out.printf("%2d : %7d: %5.2f %s%n", value, count, fraction, bar.toString());
		}
	}

	
    
	public static void main(String[] args) {
		int diceCount = 2;
		int tosses = 1000000;
		if (args.length >= 1) {
			try {
				diceCount = Integer.parseInt(args[0]);
			} catch (NumberFormatException ignored) {
			}
		}
		if (args.length >= 2) {
			try {
				tosses = Integer.parseInt(args[1]);
			} catch (NumberFormatException ignored) {
			}
		}
		Simulation sim = new Simulation(diceCount, tosses);
		sim.runSimulation();
		sim.printResults();
	}

}