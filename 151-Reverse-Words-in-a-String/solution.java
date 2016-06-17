import java.util.Arrays;

public class Solution {
    public String reverseWords(String s) {
        String[] beforeReverse = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = beforeReverse.length - 1; i >= 0; i--) {
        	if (beforeReverse[i].length() > 0) {
        		if (i != beforeReverse.length-1) {
        			sb.append(" ");
        		}
        		sb.append(beforeReverse[i]);
        	}
        }
        return sb.toString();
    }
}