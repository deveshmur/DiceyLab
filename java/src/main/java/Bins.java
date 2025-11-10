
public class Bins {
    
	private final int min;
	private final int max;
	private final int[] bins;

	public Bins(int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException("min must be <= max");
		}
		this.min = min;
		this.max = max;
		this.bins = new int[max - min + 1];
	}

	public void incrementBin(int value) {
		if (value < min || value > max) {
			throw new IllegalArgumentException("value out of range: " + value);
		}
		bins[value - min]++;
	}

	public int getBin(int value) {
		if (value < min || value > max) {
			return 0;
		}
		return bins[value - min];
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public int[] getBins() {
		return bins.clone();
	}

	public int getTotalRolls() {
    	int total = 0;
    	for (int count : bins) total += count;
    		return total;
	}


}

