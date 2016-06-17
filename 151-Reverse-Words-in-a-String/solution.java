import java.util.Arrays;

public class Solution {
    public String reverseWords(String s) {
        String[] beforeReverse = s.split(" ");
        System.out.println(Arrays.toString(beforeReverse));
        StringBuilder sb = new StringBuilder();
        for (int i = beforeReverse.length - 1; i >= 0; i--) {
        	sb.append(beforeReverse[i]);
        	sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}