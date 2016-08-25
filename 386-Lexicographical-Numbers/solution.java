import java.util.*;
public class Solution {
    public List<Integer> lexicalOrder(int n) {
    	
    	Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				//compare two integer in lexical order
				StringBuilder sb1 = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();
				while (o1 > 0) {
					sb1.insert(0, o1 % 10);
					o1 /= 10;
				}
				
				while (o2 > 0) {
					sb2.insert(0, o2 % 10);
					o2 /= 10;
				}
				
				int len = Math.min(sb1.length(), sb2.length());
				for (int i = 0; i < len; i++) {
					if (sb1.charAt(i) > sb2.charAt(i)) {
						return 1;
					} else if (sb1.charAt(i) < sb2.charAt(i)) {
						return -1;
					}
				}
				//equal
				if (sb1.length() == sb2.length()) return 0;
				if (sb1.length() < sb2.length()) return -1;
				else return 1;
				
			}
		};
		
		List<Integer> array = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			array.add(i);
		}
		array.sort(c);
//		PriorityQueue<Integer> pq = new PriorityQueue<>(c);
//		for (int i = 1; i <= n; i++) {
//			pq.add(i);
//		}
//		while (!pq.isEmpty()) {
//			System.out.println(pq.poll());
//		}
		
		return array;
    }
}