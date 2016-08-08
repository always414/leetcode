import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
		long xnumerator = numerator;
		long xdenominator = denominator;

		if (xdenominator == 0) {
			return "";
		}

		if (xnumerator == 0) {
			return "0";
		}

		boolean negative = (numerator ^ denominator) >>> 31 == 1;
		xnumerator = Math.abs(xnumerator);
		xdenominator = Math.abs(xdenominator);

		StringBuilder sb = new StringBuilder();
		int dotPos = 0;
		long div = xnumerator / xdenominator;
		long mod = xnumerator % xdenominator;

		Map<Long, Long> pair = new LinkedHashMap<>();
		while (xnumerator != 0) {
			div = xnumerator / xdenominator;
			mod = xnumerator % xdenominator;
			if (pair.containsKey(xnumerator)) {
				// find infinite loop
				StringBuilder loop = new StringBuilder();
				for (Entry<Long, Long> entry : pair.entrySet()) {
					if (entry.getKey() == xnumerator || loop.length() > 0) {
						loop.append(entry.getValue());
					}
				}
				StringBuilder inBrace = new StringBuilder("()");
				for (int i = loop.length() - 1, j = sb.length() - 1; i >= 0 && j >= dotPos; i--, j--) {
					if (loop.charAt(i) != sb.charAt(j))
						break;

					inBrace.insert(1, loop.charAt(i));
				}
				sb.delete(sb.length() - inBrace.length() + 2, sb.length());
				loop.delete(loop.length() - inBrace.length() + 2, loop.length());
				inBrace.insert(inBrace.length() - 1, loop);
				sb.append(inBrace);
				break;
			} else {
				pair.put(xnumerator, div);
				sb.append(div);
				xnumerator = mod * 10;
				if (xnumerator != 0 && dotPos == 0 && sb.length() > 0) {
					dotPos = sb.length();
				}
			}
		}

		if (dotPos != 0) {
			sb.insert(dotPos, ".");
		}

		if (negative) {
			sb.insert(0, "-");
		}
		return sb.toString();
	}
}