import java.util.BitSet;

public class PhoneDirectory {

	private final int max;
	private int smallestFreeIndex;
	BitSet bitset;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
    	this.bitset = new BitSet(maxNumbers);
    	this.max = maxNumbers;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
    	if (smallestFreeIndex == max) {
    		return -1;
    	}
    	
    	int num = smallestFreeIndex;
    	bitset.set(smallestFreeIndex);
    	smallestFreeIndex = bitset.nextClearBit(smallestFreeIndex);
    	return num;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return bitset.get(number) == false;
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
    	if (bitset.get(number) == false) {
    		return;
    	}
    	bitset.clear(number);
    	if (number < smallestFreeIndex) {
    		smallestFreeIndex = number;
    	}
    	
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */