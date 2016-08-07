import java.util.*;
import java.util.Map.Entry;

public class Solution {

	public String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0) {
			return "";
		}

		if (numerator == 0) {
			return "" + 0;
		}

		boolean negative = numerator * denominator < 0;
		denominator = Math.abs(denominator);
		numerator = Math.abs(numerator);

		Map<Integer, Integer> map = new LinkedHashMap<>();
		StringBuilder sb = new StringBuilder();
		boolean dot = false;
		int div = 0;
		int mod = 0;

		while (numerator != 0) {
			if (numerator >= denominator) {
				if (map.containsKey(numerator)) {
					// find infinite loop
					StringBuilder loop = new StringBuilder();
					for (Entry<Integer, Integer> entry : map.entrySet()) {
						if (entry.getKey() == numerator || loop.length() > 0) {
							loop.append(entry.getValue());
						}
					}
					String l = loop.toString();
					String[] res = sb.toString().split("\\."); // regex . means any character, \\. is literal dot
					if (res[1].endsWith(l)) {
						res[1] = res[1].replace(l, "(" + l + ")");
					} else {
						if (l.endsWith(res[1])) {
							l = l.substring(0, l.length() - res[1].length());
							res[1] = "(".concat(res[1]).concat(l).concat(")");
						}
					}
					sb = new StringBuilder().append(res[0]).append(".").append(res[1]);
					break;

				} else {
					div = numerator / denominator;
					mod = numerator % denominator;
					map.put(numerator, div);
					sb.append(div);
					numerator = mod;
				}
			} else {
				if (sb.length() == 0) {
					sb.append(0);
				}
				if (!dot) {
					sb.append(".");
					dot = true;
				}
				numerator *= 10;
			}
		}
		if (negative) {
			sb.insert(0, "-");
		}
		return sb.toString();

	}
}