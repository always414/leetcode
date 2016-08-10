import java.util.HashSet;
import java.util.Set;

public class PhoneDirectory {

	private final int max;
	Set<Integer> set;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        max = maxNumbers;
        set = new HashSet<>(max);
        for (int i = 0; i < max; i++) {
        	set.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
    	if (set.isEmpty()) {
    		return -1;
    	}
    	
    	int num = set.iterator().next();
    	set.remove(num);
    	return num;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !set.isEmpty() && set.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (set.size() == max) {
        	return;
        }
        set.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */