import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new ArrayList<>();

		PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				Integer sum1 = o1[0] + o1[1];
				Integer sum2 = o2[0] + o2[1];
				return sum1.compareTo(sum2);
			}
		});
		
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				int[] pair = new int[] {nums1[i], nums2[j]};
				heap.add(pair);
			}
		}
		
		while (k-- > 0) {
			if (!heap.isEmpty()) {
				res.add(heap.poll());
			}
		}
		
		return res;

	}
}