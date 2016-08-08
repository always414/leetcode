import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";

		// sign part
		StringBuilder sb = new StringBuilder();
		sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");

		long xnumerator = Math.abs((long) numerator);
		long xdenominator = Math.abs((long) denominator);

		// integal part
		sb.append(xnumerator / xdenominator);

		xnumerator %= denominator;
		if (xnumerator == 0) {
			return sb.toString();
		}

		// fractional part
		sb.append(".");
		Map<Long, Integer> pair = new LinkedHashMap<>();
		pair.put(xnumerator, sb.length());

		while (xnumerator != 0) {
			pair.put(xnumerator, sb.length());
			
			xnumerator *= 10;
			sb.append(xnumerator / xdenominator);
			xnumerator %= xdenominator;
			
			Integer remainderIndex = pair.get(xnumerator);
			if (remainderIndex != null) {
				sb.insert(remainderIndex, "(");
				sb.append(")");
				break;
			} 
		}
		return sb.toString();
	}
}