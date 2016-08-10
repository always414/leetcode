import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> generateAbbreviations(String word) {
		// bit manipulation -> 000, 111, 001, 110 ....
		// if 1 -> abbrev

		
		List<String> result = new ArrayList<>();
		int n = word.length();

		//mask < (1<<n) -> mask < 2^n
		for (int mask = 0; mask < (1<<n); mask++) {
			int count = 0;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i <= n; i++) {
				if (((1 << i) & mask) > 0) { // beautiful （1 << i） & mask  检查第i位是否为1
					count ++;
				} else {
					if (count != 0) {
						sb.append(count);
						count = 0;
					}
					
					if (i < n) sb.append(word.charAt(i));
				}
			}
			
			result.add(sb.toString());
		}
		
		return result;
	}
}