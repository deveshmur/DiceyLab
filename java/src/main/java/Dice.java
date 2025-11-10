
public class Dice {
	private final int numberOfDice;
	private final java.util.Random random = new java.util.Random();

	public Dice(int numberOfDice) {
		if (numberOfDice < 1) {
			throw new IllegalArgumentException("numberOfDice must be >= 1");
		}
		this.numberOfDice = numberOfDice;
	}


	public int tossAndSum() {
		int sum = 0;
		for (int i = 0; i < numberOfDice; i++) {
			sum += random.nextInt(6) + 1;
		}
		return sum;
	}

	public int getNumberOfDice() {
		return numberOfDice;
	}


}
