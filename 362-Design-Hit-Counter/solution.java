import java.util.*;

public class HitCounter {

	Queue<Integer> queue;
    /** Initialize your data structure here. */
    public HitCounter() {
        //some data structure
    	//1. implement queue. return queue.size
    	queue = new ArrayDeque<>();
    	
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        //store
    	queue.add(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        //get counts
    	while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
    		queue.poll();
    	}
    	return queue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */