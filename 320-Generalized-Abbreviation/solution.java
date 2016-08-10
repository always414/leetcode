import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> generateAbbreviations(String word) {
		// bit manipulation -> 000, 111, 001, 110 ....
		// if 1 -> abbrev

		int n = word.length();
		int size = (int) Math.pow(2, n);
		char[] chars = word.toCharArray();
		List<String> result = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			result.add(generateWord(chars, i));
		}
		return result;
	}

	private String generateWord(char[] chars, int binaryRepresentation) {
		System.out.println(Integer.toBinaryString(binaryRepresentation));
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			int abbrev = binaryRepresentation & 1;
			binaryRepresentation >>= 1;
			if (abbrev == 1) {
				// abbrev
				count++;
			} else {
				// no abbrev, deal with count
				if (count != 0) {
					sb.append(count);
					count = 0;
				}
				sb.append(chars[i]);
			}
		}
		if (count != 0) {
			sb.append(count);
		}
		return sb.toString();
	}

}