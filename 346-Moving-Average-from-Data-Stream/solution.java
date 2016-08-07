import java.util.ArrayList;
import java.util.List;

public class MovingAverage {
	private List<Integer> numbers;
	private final int maxSize;
	private double sum;

	/** Initialize your data structure here. */
	public MovingAverage(int size) {
		maxSize = size;
		numbers = new ArrayList<>(size);
		sum = 0;
	}

	public double next(int val) {
		if (numbers.size() == maxSize) {
			sum -= numbers.remove(0);
		}
		numbers.add(val);
		sum += val;
		return sum / numbers.size();
	}
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size); double param_1 = obj.next(val);
 */